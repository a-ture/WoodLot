import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {
  ValidazioneFormAggiornamentoStatoService
} from "../../../../servizi/validazioneFormAggiornamentoStato/validazione-form-aggiornamento-stato.service";

@Component({
  selector: 'app-card-albero-contadino',
  templateUrl: './card-albero-contadino.component.html',
  styleUrls: ['./card-albero-contadino.component.scss']
})
export class CardAlberoContadinoComponent implements OnInit {

  @Input()
  public titolo !: String

  @Input()
  public sourceImage !: String

  @Input()
  public id !: number

  @Input()
  public stato !: String

  @Input()
  public dataModifica !: Date | undefined

  public visible = false;

  formAggionaStato: FormGroup
  submitted = false;
  formErrori: any;

  toggleModal() {
    this.visible = !this.visible;
  }

  handleModal(event: any) {
    this.visible = event;
  }

  constructor(private serviceValidazione: ValidazioneFormAggiornamentoStatoService) {
    this.formAggionaStato = new FormGroup({
      breveDescrizione: new FormControl('', [Validators.required,
        Validators.maxLength(serviceValidazione.regoleForm.descizioneBreveMax)]),
      frutta: new FormControl('', [Validators.required, Validators.pattern(serviceValidazione.regoleForm.quantitaFrutta)]),
      foto: new FormControl('', [Validators.required]),
      senescenza: new FormControl('', [Validators.required])
    })
    this.formErrori = this.serviceValidazione.errori;
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.onValidate()) {
      // TODO: Submit form value
      console.warn(this.formAggionaStato.value);
      alert('SUCCESS!');
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
