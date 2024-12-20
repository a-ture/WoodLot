import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BeneficioService} from "../../../../servizi/beneficio/beneficio.service";
import {UsoLocaleService} from "../../../../servizi/usoLocale/uso-locale.service";
import {PaeseService} from "../../../../servizi/paese/paese.service";
import {
  ValidazioneFormProdottoService
} from "../../../../servizi/validazioneFormProdotto/validazione-form-prodotto.service";
import {Beneficio} from "../../../../entita/beneficio/beneficio";
import {UsoLocale} from "../../../../entita/usoLocale/uso-locale";
import {Paese} from "../../../../entita/paese/paese";
import {Categoria} from "../../../../entita/categoria/categoria";
import {CategoriaService} from "../../../../servizi/categoria/categoria.service";
import {ProdottoService} from "../../../../servizi/prodotto/prodotto.service";
import {Albero} from "../../../../entita/albero/albero";
import {Router} from "@angular/router";
import {forkJoin} from "rxjs";


@Component({
  selector: 'app-sezione-aggiungi',
  templateUrl: './sezione-aggiungi.component.html',
  styleUrls: ['./sezione-aggiungi.component.scss']
})
export class SezioneAggiungiComponent implements OnInit {

  formInserimento!: FormGroup
  submitted = false;
  formErrori: any;
  errorMessage: string = '';
  fileToUpload1!: File;
  fileToUpload2!: File;
  fileToUpload3!: File;
  fileToUpload4!: File;


  public listaBenefici !: Beneficio[]
  public listaUsiLocali !: UsoLocale[]
  public listaPaesi !: Paese[]
  public listaCategorie!: Categoria[]

  constructor(private serviceValidazioneFormProdotto: ValidazioneFormProdottoService,
              private serviceBeneficio: BeneficioService, private serviceCategoria: CategoriaService,
              private serviceUsiLocali: UsoLocaleService, private servicePaese: PaeseService,
              private serviceProdotto: ProdottoService, private router: Router) {
  }

  onFileSelected1(event: any) {
    const file = event.target.files[0];
    const newName = '1.webp';
    const modifiedFile = new File([file], newName, {type: file.type});
    this.fileToUpload1 = modifiedFile;
  }

  onFileSelected2(event: any) {
    const file = event.target.files[0];
    const newName = '2.webp';
    const modifiedFile = new File([file], newName, {type: file.type});
    this.fileToUpload2 = modifiedFile;
  }

  onFileSelected3(event: any) {
    const file = event.target.files[0];
    const newName = '3.webp';
    const modifiedFile = new File([file], newName, {type: file.type});
    this.fileToUpload3 = modifiedFile;
  }

  onFileSelected4(event: any) {
    const file = event.target.files[0];
    const newName = 'catalogo.webp';
    const modifiedFile = new File([file], newName, {type: file.type});
    this.fileToUpload4 = modifiedFile;
  }

  ngOnInit(): void {
    this.servicePaese.getPaesi().subscribe(data => {
      this.listaPaesi = data;
    });
    this.serviceUsiLocali.getUsiLocali().subscribe(data => {
      this.listaUsiLocali = data;
    });
    this.serviceBeneficio.getBenefici().subscribe(data => {
      this.listaBenefici = data;
    });
    this.serviceCategoria.getCategorie().subscribe(data => {
      this.listaCategorie = data
    })
    this.formInserimento = new FormGroup(
      {
        nomeAlbero: new FormControl('', [Validators.required,
          Validators.maxLength(10),
          Validators.pattern(this.serviceValidazioneFormProdotto.regoleForm.nomeAlbero)]),
        specieScientifica: new FormControl('', [Validators.required,
          Validators.maxLength(30),
          Validators.pattern(this.serviceValidazioneFormProdotto.regoleForm.specieScientifca)]),
        descrizioneBreve: new FormControl('', [Validators.required,
          Validators.maxLength(50)]),
        descrizione: new FormControl('', [Validators.required,
          Validators.maxLength(500)]),
        prezzo: new FormControl('', [Validators.required,
          Validators.pattern(this.serviceValidazioneFormProdotto.regoleForm.prezzo)]),
        salvaguardia: new FormControl('', [Validators.required,
          Validators.pattern(this.serviceValidazioneFormProdotto.regoleForm.salvaguardia)]),
        anidrideCarbonica: new FormControl('', [Validators.required,
          Validators.pattern(this.serviceValidazioneFormProdotto.regoleForm.anidrideCarbonica)]),
        foto1: new FormControl('', [Validators.required, Validators.pattern("^\\S+\\.webp$")]),
        foto2: new FormControl('', [Validators.required, Validators.pattern("^\\S+\\.webp$")]),
        foto3: new FormControl('', [Validators.required, Validators.pattern("^\\S+\\.webp$")]),
        foto4: new FormControl('', [Validators.required, Validators.pattern("^\\S+\\.webp$")]),
        paese: new FormControl('Argentina', [Validators.required]),
        usiLocali: new FormControl('', [Validators.required]),
        benefici: new FormControl('', [Validators.required]),
        categoria: new FormControl('Rischio estinzione', [Validators.required])
      }
    )
    this.formErrori = this.serviceValidazioneFormProdotto.errori
  }

  onValidate() {
    this.submitted = true;

    return this.formInserimento.status === 'VALID';
  }

  onSubmit(): void {
    this.errorMessage = ''
    if (this.onValidate()) {

      let nomeAlbero = this.formInserimento.get('nomeAlbero')?.value
      let specieScientifica = this.formInserimento.get('specieScientifica')?.value
      let descrizioneBreve = this.formInserimento.get('descrizioneBreve')?.value
      let descrizione = this.formInserimento.get('descrizione')?.value
      let prezzo = this.formInserimento.get('prezzo')?.value
      let anidrideCarbonica = this.formInserimento.get('anidrideCarbonica')?.value
      let salvaguardia = this.formInserimento.get('salvaguardia')?.value

      let usiLocali = this.formInserimento.get('usiLocali')?.value
      let usiLocaliArray = new Array<UsoLocale>()
      usiLocali.forEach((e: string) => {
        let u = new UsoLocale(e, "")
        usiLocaliArray.push(u)
      });
      console.log(usiLocaliArray)

      let benefici = this.formInserimento.get('benefici')?.value
      let beneficiArray = new Array<Beneficio>()
      benefici.forEach((e: string) => {
        let u = new Beneficio(e, "")
        beneficiArray.push(u)
      });
      console.log(beneficiArray)

      let paese = this.formInserimento.get('paese')?.value
      let categoria = this.formInserimento.get('categoria')?.value

      let cat = new Categoria(categoria, "")
      let p = new Paese(paese, "")
      let albero = new Albero(prezzo, anidrideCarbonica, nomeAlbero,
        specieScientifica, descrizioneBreve, descrizione, salvaguardia, usiLocaliArray, beneficiArray, cat, p)
      console.log(albero)

      this.serviceProdotto.salvaAlbero(albero).subscribe(
        (data: Albero) => {
          console.log(data)
          const saveFoto1$ = this.serviceProdotto.salvaFoto(nomeAlbero, this.fileToUpload1);
          const saveFoto2$ = this.serviceProdotto.salvaFoto(nomeAlbero, this.fileToUpload2);
          const saveFoto3$ = this.serviceProdotto.salvaFoto(nomeAlbero, this.fileToUpload3);
          const saveFoto4$ = this.serviceProdotto.salvaFoto(nomeAlbero, this.fileToUpload4);

          forkJoin([saveFoto1$, saveFoto2$, saveFoto3$, saveFoto4$]).subscribe(
            () => {
              this.router.navigate(['/paginaProdotto', albero.nome]);
            },
            (error) => {
              this.errorMessage = JSON.stringify(error.error.data);
              console.log(this.errorMessage)
              this.errorMessage = JSON.stringify(error.error.data)
            }
          );
          this.router.navigate(['/paginaProdotto', albero.nome])
        },
        (error) => {
          console.log(error.error.data)
          this.errorMessage = JSON.stringify(error.error.data)
        })
    }
  }

  //getter per un facile accesso ai campi del modulo
  get f() {
    return this.formInserimento.controls;
  }

}
