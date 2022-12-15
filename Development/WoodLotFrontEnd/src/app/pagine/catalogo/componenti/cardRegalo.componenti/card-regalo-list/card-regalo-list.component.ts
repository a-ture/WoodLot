import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card-regalo-list',
  templateUrl: './card-regalo-list.component.html',
  styleUrls: ['./card-regalo-list.component.scss']
})
export class CardRegaloListComponent implements OnInit {

  public listTitoli = [
    "Laurea", "Natale", "Nascita", "Anniversario", "Compleanno", "Matrimonio", "Bomboniere",
    "Ricorrenze", "Per Amore", "Regali Solidali"
  ]

  public listSourceImage = [
    "assets/img/catalogo/regali/laurea.png",
    "assets/img/catalogo/regali/natale.png",
    "assets/img/catalogo/regali/nascita.png",
    "assets/img/catalogo/regali/anniversari.png",
    "assets/img/catalogo/regali/compleanno.png",
    "assets/img/catalogo/regali/matrimoni.png",
    "assets/img/catalogo/regali/bomboniere.png",
    "assets/img/catalogo/regali/ricorrenze.png",
    "assets/img/catalogo/regali/perAmore.png",
    "assets/img/catalogo/regali/regaliSolidali.png",
  ]

  public listDescrizioni = [
    "Dottore o Dottoressa che sia, di sicuro si merita un bel regalo per la laurea. E a qualcuno che si è " +
    "appena laureato non puoi certo permetterti di fare un regalo banale" +
    "! Regalando un albero non corri questo rischio",

    "I regali di Natale possono essere un grande incubo di carenza d’idee e code alle casse. Per non parlare dei regali" +
    "per Natale originali e divertenti; quelli possono diventare un vero miraggio. Regalare un albero per Natale è la " +
    "soluzione ideale per trasformare l’incubo in un sogno ed il miraggio in realtà.",
    "In molte culture, alla nascita di un bambino, era tradizione piantare un nuovo albero. Un gesto concreto e di " +
    "grande valenza simbolica. Oggi puoi piantare un albero con WoodLot e farne un regalo per neonati o utilizzarlo come " +
    "idea regalo per un battesimo.",

    "Un regalo per l’anniversario di un matrimonio? Oppure un regalo d’anniversario per chi, comunque, ti sopporta " +
    "da anni? O un regalo per l’anniversario di un giorno speciale per te ed i tuoi amici. In ogni caso, regalare un " +
    "albero è il modo perfetto per celebrare degnamente un anniversario importante.",

    "La canzone è sempre la solita, tanti auguri a te! Ma il regalo di compleanno deve essere sempre diverso ed avere " +
    "ogni volta la giusta idea regalo è una bella sfida. Un albero può essere proprio quello che cercavi!",

    "E così hanno deciso di sposarsi. Ora non resta che scegliere l’abito per la cerimonia e i festeggiamenti. " +
    "Ma soprattutto si tratta di trovare il giusto regalo di matrimonio. Che porti un messaggio d’auguri, che duri nel " +
    "tempo e che sia di buon auspicio. Cosa c’è di meglio che regalare un albero per un matrimonio?",

    "Nascita, battesimo, comunione, cresima, laurea, matrimonio; tutte occasioni in cui non è facile trovare l’idea " +
    "giusta per regalare bomboniere agli invitati. Ecco che gli alberi diventano una soluzione originale, per un regalo " +
    "adatto a bambini e adulti. Utile, eco e solidale.",

    "Non è vero che tutti giorni sono uguali. Il calendario è pieno di giornate speciali che meritano di essere celebrate." +
    "Ognuna di esse, può essere l'occasione giusta per regalare un albero!.",

    "Per far sorridere la tua dolce metà, serve un regalo che sia all’altezza del vostro amore. " +
    "Un albero, o meglio ancora una coppia d’alberi! Una perfetta idea regalo. Basta un click per piantare e condividere.",

    "Non è come regalare una stella. Un albero ha solide radici e con WoodLot può diventare una perfetta idea regalo. " +
    "Un regalo solidale ed ecosostenibile. Un regalo per offrire un pensiero green ed un gesto concreto."
  ]

  public listTitoliModal =[
    "Regali con lode!", "Per un verde Natale!","Un albero è vità!", "Un albero è per sempre!", "Un albero di compleanno",
    "Alberi per gli sposi!","Alberi come bomboniere!",  "Festeggia con un albero!", "Alberi per amore!", "Un albero fa bene!"
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
