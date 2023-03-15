import {Component, Input, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {
  ValidazioneFormAggiornamentoStatoService
} from "../../../../servizi/validazioneFormAggiornamentoStato/validazione-form-aggiornamento-stato.service";
import {ProdottoOrdine} from "../../../../entita/prodottoOrdine/prodotto-ordine";
import {ContadinoService} from "../../../../servizi/contadino/contadino.service";
import {forkJoin} from "rxjs";

@Component({
  selector: 'app-card-albero-contadino',
  templateUrl: './card-albero-contadino.component.html',
  styleUrls: ['./card-albero-contadino.component.scss']
})
export class CardAlberoContadinoComponent implements OnInit {

  @Input()
  public alberoContadino !: ProdottoOrdine
  @Input()
  public sourceImage !: String
  public visible = false;
  fileToUpload!: File;
  errorMessage: string = '';
  formAggionaStato!: FormGroup
  submitted = false;
  formErrori: any;
  isChecked = false;

  toggleModal() {
    this.visible = !this.visible;
  }

  handleModal(event: any) {
    this.visible = event;
  }

  onFileSelected(event: any) {
    const file = event.target.files[0];
    const newName = this.alberoContadino.id + '.jpeg';
    const modifiedFile = new File([file], newName, {type: file.type});
    this.fileToUpload = modifiedFile;
  }

  get randomParam() {
    return Math.random();
  }

  constructor(private serviceValidazione: ValidazioneFormAggiornamentoStatoService, private serviceContadino: ContadinoService) {

  }

  ngOnInit(): void {
    this.formAggionaStato = new FormGroup({
      breveDescrizione: new FormControl('', [Validators.required,
        Validators.maxLength(50)]),
      frutta: new FormControl(''),
      foto: new FormControl('', [
        Validators.required,
        Validators.pattern('^\\S+\\.jpeg$')
      ]),
      senescenza: new FormControl('')
    })
    if (this.alberoContadino.stato === 'Frutto' || this.alberoContadino.stato === 'Fiore') {
      this.formAggionaStato.get('frutta')?.setValidators([Validators.required, Validators.pattern("^[0-9]+(.[0-9]+)?$")])
    }
    this.formErrori = this.serviceValidazione.errori;
  }

  onSubmit(): void {
    if (this.onValidate()) {
      let breveDescrizione = this.formAggionaStato.get('breveDescrizione')?.value;
      let frutta = this.formAggionaStato.get('frutta')?.value;
      let senescenza = this.isChecked

      this.alberoContadino.descrizione = breveDescrizione
      if (frutta) {
        this.alberoContadino.frutta = frutta
      }
      if (senescenza) {
        this.alberoContadino.stato = 'Senescenza'
      } else {
        if (this.alberoContadino.stato == 'Assegnato') {
          this.alberoContadino.stato = 'Piantato'
        } else if (this.alberoContadino.stato == 'NonAssegnato') {
          this.alberoContadino.stato = 'Assegnato'
        } else if (this.alberoContadino.stato == 'Piantato') {
          this.alberoContadino.stato = 'Bocciolo'
        } else if (this.alberoContadino.stato == 'Bocciolo') {
          this.alberoContadino.stato = 'Fiore'
        } else if (this.alberoContadino.stato == 'Fiore') {
          this.alberoContadino.stato = 'Frutto'
        } else if (this.alberoContadino.stato == 'Frutto') {
          this.alberoContadino.stato = 'Dormienza'
        } else if (this.alberoContadino.stato == 'Dormienza') {
          this.alberoContadino.stato = 'Piantato'
        }
      }
      console.log(this.alberoContadino)

      this.serviceContadino.aggiornaStato(this.alberoContadino).subscribe(
        (data: ProdottoOrdine) => {
          this.alberoContadino = data
          const saveFoto1 = this.serviceContadino.salvaFoto(this.alberoContadino.contadino?.id + "", this.fileToUpload);

          forkJoin([saveFoto1]).subscribe(
            () => {
              console.log(this.alberoContadino)
            },
            (error) => {
              this.errorMessage = JSON.stringify(error.data);
              console.log(this.errorMessage)
              this.errorMessage = JSON.stringify(error.data)
            }
          );
        },
        (error) => {
          this.errorMessage = JSON.stringify(error.data)
        }
      )
    }
  }

  onValidate() {
    this.submitted = true;
    //fermati qui se il modulo non è valido
    return this.formAggionaStato.status === 'VALID';
  }

  //getter per un facile accesso ai campi del modulo
  get f() {
    return this.formAggionaStato.controls;
  }

}
