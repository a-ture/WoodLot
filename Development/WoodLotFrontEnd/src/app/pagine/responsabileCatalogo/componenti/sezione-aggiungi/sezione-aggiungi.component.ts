import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BeneficioService} from "../../../../servizi/beneficio/beneficio.service";
import {UsoLocaleService} from "../../../../servizi/usoLocale/uso-locale.service";
import {PaeseService} from "../../../../servizi/paese/paese.service";
import {
  ValidazioneFormProdottoService
} from "../../../../servizi/validazioneFormProdotto/validazione-form-prodotto.service";

//TODO vedere il paese, usi locali e benefici
@Component({
  selector: 'app-sezione-aggiungi',
  templateUrl: './sezione-aggiungi.component.html',
  styleUrls: ['./sezione-aggiungi.component.scss']
})
export class SezioneAggiungiComponent implements OnInit {

  formInserimento: FormGroup
  submitted = false;
  formErrori: any;

  public listaBenfici
  public listaUsiLocali
  public listaPaesi

  constructor(private serviceValidazioneFormProdotto: ValidazioneFormProdottoService,
              private serviceBeneficio: BeneficioService,
              private serviceUsiLocali: UsoLocaleService, private servicePaese: PaeseService) {
    this.formInserimento = new FormGroup(
      {
        nomeAlbero: new FormControl('', [Validators.required,
          Validators.maxLength(serviceValidazioneFormProdotto.regoleForm.nomeAlberoMax),
          Validators.pattern(serviceValidazioneFormProdotto.regoleForm.nomeAlbero)]),
        specieScientifica: new FormControl('', [Validators.required,
          Validators.maxLength(serviceValidazioneFormProdotto.regoleForm.specieScientificaMax),
          Validators.pattern(serviceValidazioneFormProdotto.regoleForm.specieScientifca)]),
        descrizioneBreve: new FormControl('', [Validators.required,
          Validators.maxLength(serviceValidazioneFormProdotto.regoleForm.descizioneBreveMax)]),
        descrizione: new FormControl('', [Validators.required,
          Validators.maxLength(serviceValidazioneFormProdotto.regoleForm.descrizioneMax)]),
        prezzo: new FormControl('', [Validators.required,
          Validators.pattern(serviceValidazioneFormProdotto.regoleForm.prezzo)]),
        salvaguardia: new FormControl('', [Validators.required,
          Validators.pattern(serviceValidazioneFormProdotto.regoleForm.salvaguardia)]),
        anidrideCarbonica: new FormControl('', [Validators.required,
          Validators.pattern(serviceValidazioneFormProdotto.regoleForm.anidrideCarbonica)]),
        foto1: new FormControl('', [Validators.required]),
        foto2: new FormControl('', [Validators.required]),
        foto3: new FormControl('', [Validators.required])
      }
    )
    this.formErrori = serviceValidazioneFormProdotto.errori
    this.listaBenfici = serviceBeneficio.getBenefici()
    this.listaUsiLocali = serviceUsiLocali.getUsiLocali()
    this.listaPaesi = servicePaese.getPaesi()
  }


  ngOnInit(): void {
  }

  onValidate() {
    this.submitted = true;
    //fermati qui se il modulo non è valido
    return this.formInserimento.status === 'VALID';
  }

  onSubmit(): void {
    if (this.onValidate()) {
      // TODO: Submit form value
      console.warn(this.formInserimento.value);
      alert('SUCCESS!');
    }
  }

  //getter per un facile accesso ai campi del modulo
  get f() {
    return this.formInserimento.controls;
  }
}
