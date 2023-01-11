import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-molto-piu-di-un-albero',
  templateUrl: './molto-piu-di-un-albero.component.html',
  styleUrls: ['./molto-piu-di-un-albero.component.scss']
})
export class MoltoPiuDiUnAlberoComponent implements OnInit {

  public listTitoli = [
    "Benefici ambientali", "Benefici sociali", "Ogni albero nel modo giusto", "Piantare alberi è (sempre) una buona idea?"
  ]

  public listTesto = [
    "La realizzazione di sistemi agroforestali permette di operare scelte puntuali in relazione alle specifiche " +
    "caratteristiche e necessità di ogni area di progetto. Le specie arboree piantate sono native o in rispetto " +
    "della biodiversità dei diversi territori. La pratica agroforestale integra inoltre la piantumazione di alberi " +
    "in un sistema agricolo, favorendo l’interazione virtuosa tra le diverse specie ed un uso sostenibile delle risorse " +
    "e dei terreni. Tutti gli alberi, infine, nel corso della propria crescita assorbono anidride carbonica generando" +
    " naturalmente un beneficio per l’intero pianeta ",
    "WoodLot finanzia progetti presso comunità rurali in vari paesi del mondo e realizza anche in Italia progetti a " +
    "forte valenza sociale. Il primo passo è la formazione e il finanziamento delle comunità coinvolte nei progetti, " +
    "ottenendo straordinari risultati in termini di empowerment delle stesse. Gli alberi e i loro frutti sono di " +
    "proprietà dei contadini, permettendo loro di diversificare ed integrare il proprio reddito e in alcuni casi di" +
    " avviare iniziative di microimprenditorialità. Finanziare la piantumazione di nuovi alberi con WoodLot, serve a " +
    "sostenerne la cura nei primi anni di vita, quando non sono ancora produttivi in termini di frutti",
    "Crediamo che gettare 100 semi in un campo, non significhi aver piantato 100 alberi. E crediamo che piantare una " +
    "sola specie, in modo intensivo, non sia una scelta sostenibile e rispettosa della biodiversità. Crediamo che le " +
    "comunità di persone che vivono in un luogo siano i migliori custodi degli alberi, per questo le sosteniamo " +
    "finanziariamente e le aiutiamo a piantare e far crescere alberi nei loro terreni. Gli alberi daranno benefici " +
    "a loro, al luogo in cui vivono e a tutto il pianeta. Crediamo nel legame che, attraverso gli alberi e grazie " +
    "a WoodLot, si può creare tra persone lontane. Crediamo che ciascuno di noi debba impegnarsi per ridurre le proprie " +
    "emissioni di CO2 e che nel farlo possa contribuire anche ad assorbirne piantando alberi. Crediamo che si possa " +
    "rendere questo pianeta più verde. E vogliamo farlo nel modo giusto.",
    "Negli ultimi anni sono stati annunciati enormi progetti di piantumazione di alberi. Sono popolari, raccontati in " +
    "molti canali mediatici e spesso hanno numeri sbalorditivi. Ci sono però dei limiti in queste attività, perché se è " +
    "vero che piantare alberi fa bene al pianeta, è ancora più vero che farlo in modo non corretto può creare danni " +
    "enormi agli ecosistemi, alle riserve di acqua, all’agricoltura e anche alle persone. Foreste artificiali " +
    "(con una sola o con poche specie non autoctone) impoveriscono la biodiversità locale, trasfigurano interi " +
    "ecosistemi e mettono a rischio le riserve idriche di intere regioni.",

  ]

  public listSourceImage = [
    "assets/img/chiSiamo/05.jpg",
    "assets/img/chiSiamo/02.jpg",
    "assets/img/chiSiamo/04.jpg",
    "assets/img/chiSiamo/03.jpeg"
  ]

  public listClassi = [
    "col-md-7 col-sm-12", "col-md-7 order-md-2 col-sm-12"
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}
