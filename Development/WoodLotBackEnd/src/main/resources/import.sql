/*Non formattare il codice in automatico da errore*/

/*Usi Locali*/
INSERT INTO uso_locale (nome, descrizione) VALUES ("Medicina", "Le foglie, le radici, la corteccia e/o i frutti vengono usati nella medicina tradizionale.");
INSERT INTO uso_locale (nome, descrizione) VALUES ("Vendita","I frutti, i semi e/o le foglie vengono mangiati dalle famiglie dei contadini o venduti nei mercati locali.");
INSERT INTO uso_locale (nome, descrizione) VALUES ("Suolo",  "Migliora la qualità del suolo fissando l’azoto o riduce l'erosione grazie all'esteso apparato radicale.");
INSERT INTO uso_locale (nome, descrizione) VALUES ("Recinzione", "Permette di proteggere un’area coltivata o di dare ristoro agli animali al pascolo.");
INSERT INTO uso_locale (nome, descrizione) VALUES ("Antivento", "Protegge dal vento le giovani piante e riduce l'evaporazione dell'acqua dal suolo.");
INSERT INTO uso_locale (nome, descrizione) VALUES ("Cosmesi", "Dai suoi fiori, frutti e/o foglie si estraggono materie prime utilizzate per produrre creme o polveri.");
INSERT INTO uso_locale (nome, descrizione) VALUES ("Allevamento", "Le foglie, fresche o essiccate, vengono utilizzate come mangime per il bestiame.");
INSERT INTO uso_locale (nome, descrizione) VALUES ("Insetticida","Le foglie e/o i frutti contengono sostanze utili contro le fitopatologie e utilizzabili come insetticidi naturali.");

/*Benefici*/
INSERT INTO beneficio (nome, descrizione) VALUES ("Sicurezza alimentare","Gli alberi daranno frutti, alcuni che saranno immediatamente commestibili e altri che potranno diventare commestibili attraverso la lavorazione, garantendo risorse alimentari nel tempo.");
INSERT INTO beneficio (nome, descrizione) VALUES ("Sviluppo economico","I frutti degli alberi e i prodotti derivati dalla loro trasformazione possono essere scambiati in reti locali, offrendo opportunità di reddito.");
INSERT INTO beneficio (nome, descrizione) VALUES ("Assorbimento di Anidride Carbonica","Durante il suo ciclo di vita, ogni albero compenserà l' anidride carbonica. Gli alberi che pianti possono compensare le tue emissioni");
INSERT INTO beneficio (nome, descrizione) VALUES ("Protezione ambientale","Gli alberi sono piantati in sistemi agroforestali che favoriscono l'interazione virtuosa tra le diverse specie e il loro impatto positivo sull'ambiente e sul territorio.");

/*Categorie*/
INSERT INTO categoria (nome, descrizione) VALUES ("Svilluppo sostenibile","L’educazione è il motore dello sviluppo sostenibile. I valori fondamentali insegnati ai bambini sono il rispetto dell’ambiente, l’uso di materiali riciclati e l’interiorizzazione di uno stile di vita sostenibile a 360°!");
INSERT INTO categoria (nome, descrizione) VALUES ("Salvaguardia ambientale","Ci addentriamo nella foresta amazzonica per recuperare sementi storici di alberi forestali, che poi coltiviamo in vivaio. Questi alberi vengono inseriti in sistemi forestali misti in cui la varietà di specie assicura la stabilità e la resilienza dell’impianto.");
INSERT INTO categoria (nome, descrizione) VALUES ("Rischio estinzione","L'albero è classificato come “in pericolo” nella Lista rossa delle specie minacciate dell’IUCN (Unione internazionale per la conservazione della natura).");

/*Paesi*/
INSERT INTO paese_origine (nome, descrizione) VALUES ("Italia","L'Italia non è solo il paese in cui WoodLot è stata fondata nel 2022, ma è anche uno dei paesi in cui piantiamo alberi. Si tratta di progetti dai numeri piuttosto contenuti, ma non per questo meno importanti. I progetti a cui diamo vita in Italia rispettano la nostra filosofia, che è quella di produrre benefici sociali e ambientali, ma la applicano ad un contesto diverso rispetto a quelli degli altri paesi in cui lavoriamo. Se i benefici ambientali si realizzano anche in Italia grazie alla piantumazione di nuovi alberi, per i benefici sociali è decisiva la scelta dei nostri partner di progetto. Questi sono associazioni, onlus, cooperative sociali (non lavoriamo con soggetti privati) che, ad esempio, includono categorie in difficoltà nelle proprie attività oppure recuperano aree confiscate alla criminalità organizzata. L'intento è quello di sostenere progetti di grande valenza sociale.");
INSERT INTO paese_origine (nome, descrizione) VALUES ("Guatemala","Il nostro lavoro in Guatemala intende realizzare molteplici benefici, tarando i progetti sulle differenti realtà territoriali e sociali con le quali lavoriamo. Come accennato, una delle zone in cui operiamo si trova nell'area rurale del Petén, nel nord del paese, qui abbiamo individuato nelle specie da frutto, il perno del nostro progetto per garantire i migliori benefici ambientali e sociali. Tra le specie di alberi che contribuiscono a creare sistemi agroforestali vi sono: Lime, Mandarino, Mango, Cacao, Graviola (conosciuta anche come Corossole o Guanàbana), Sapote (tradizionale albero da frutto assai diffuso presso le civiltà precolombiane dell'America Centrale), Guava e Arancio. Gli alberi saranno piantati in sistemi agroforestali su piccola scala, secondo i principi della permacultura, un approccio che imita i processi naturali, creando consociazioni di specie diverse.");
INSERT INTO paese_origine (nome, descrizione) VALUES ("Argentina","Il territorio dell'Argentina corre per 3.700 Km da nord a sud e per 1.400 da est a ovest. Al centro del paese sta la grande distesa pianeggiante della Pampa, intorno alla quale si trovano: la regione subtropicale del Gran Chaco a nord, il plateau della Patagonia a sud, mentre a ovest s'innalzano le maestose vette delle Ande. A tanta varietà d'ambienti corrisponde altrettanta varietà di fauna, che va dal caimano (o yacaré) al celebre condor delle Ande. L'avventura in Argentina si è svolta nelle foreste del Gran Chaco. Le risorse naturali di questa regione sono state seriamente danneggiate dalla deforestazione e abbiamo contribuito al loro ripristino, piantando alberi utili per la popolazione locale, come ad esempio l'Algarrobo.");
INSERT INTO paese_origine (nome, descrizione) VALUES ("Perù","Il Perù è un grande paese, con un enorme patrimonio naturale ed una popolazione in crescita. Crediamo che uno sviluppo sostenibile del paese non possa che passare attraverso una diffusa sensibilità verso l'ambiente ed un giusto equilibrio con l'utilizzo delle risorse che questo può offrire alle popolazioni locali.Per questo abbiamo deciso di puntare con decisione sul Perù per lo sviluppo dei nostri progetti, mirati a sviluppare tanto il lavoro di preservazione di ambienti naturali, quanto l'integrazione degli alberi nei sistemi agricoli locali.");

/*Utenti*/
INSERT INTO utente (id,nome, cognome, data_di_nascita, email, password) VALUES(1,"Alessia","Ture", '2001-02-23', "alessiature@gmail.com", "briciola");
INSERT INTO utente (id,nome, cognome, data_di_nascita, email, password) VALUES(2,"Raffaella","Spagnuolo", '2001-02-23', "raffaellaspaguonolo@gmail.com", "frida");

/*Contadini*/
INSERT INTO contadino (id, nome, cognome, data_di_nascita, email, password, coordinate_geografiche) VALUES(1, "Pedro", "Garica", "2001-02-23", "pedrogarcia@gmail.com", "alessiature01", "Guatemala");

/*Responsabile Catalogo*/
INSERT INTO responsabile_catalogo(id,email, password,nome, cognome) VALUES (1,"catalogo@gmail.com","catalogo","Mario","Rossi");

/*Responsabile Ordini*/
INSERT INTO responsabile_ordini(id,email, password,nome, cognome) VALUES (1,"ordini@gmail.com","ordini","Stefano","Bianchi");

/*Alberi*/
/*Albero dinamite*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES ("Albero Dinamite", "Hura crepitans", "Il nome scientifico di questa specie è Hura Crepitans. Crepitans è un termine latino che si riferisce tanto a qualcosa che si rompe, che al rumore che questa rottura genera. Il motivo per cui questa parola è riferita al nostro albero è per via dei suoi frutti, che quando sono maturi esplodono, letteralmente, facendo schizzare i semi a gran velocità fino a 15-20 metri di distanza (alcuni dicono fino a 50 metri, ma a noi pare troppo). Ecco perché questo albero è detto anche Albero Dinamite.","A giusta distanza! Ad un albero che spara i propri semi come proiettili, è opportuno stare a distanza. Ma conviene ancora di più perché l'Albero Dinamite ha il tronco coperto di spine e tutte le sue parti contengono una sostanza altamente tossica, capace di causare la cecità se viene a contatto con gli occhi. Ecco che stare a giusta distanza diventa un consiglio da seguire con attenzione!", "Argentina", 67.90, 45, 4,"Rischio estinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Albero Dinamite", "Cosmesi");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Albero Dinamite", "Vendita");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Albero Dinamite", "Sviluppo economico");

/*Anacardo*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES ("Anacardo", "Anacardium occidentale", "Specie originaria del Brasile, è un albero sempreverde molto ramificato. Il frutto si compone di una parte una carnosa simile ad una mela - in realtà un falso frutto - e di una parte secca: l'anacardo che tutti noi conosciamo. L'anacardo viene piantato per aiutare l'economia delle piccole comunità rurali del Senegal e per proteggere gli appezzamenti dal fuoco.","Amore! La parola anacardo deriva dal greco 'kardia', cuore, e per questo è uno dei frutti dell'amore.", "Guatemala", 35.90, 347, 4, "Salvaguardia ambientale");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Anacardo", "Insetticida");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Anacardo", "Antivento");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Anacardo", "Sviluppo economico");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Anacardo", "Sicurezza alimentare");

/*Arancio*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES ("Arancio", "Citrus × aurantium","Originario della Cina meridionale, l'Arancio è un sempreverde che produce, oltre ai succosi frutti che tutti conosciamo, piccoli fiori bianchi e verdi molto profumati. Viene piantato per l'utilizzo alimentare e per aiutare l'economia locale attraverso il commercio di frutti.", "Ottimismo! Il colore arancione, tipico dei rotondi frutti di questo albero, simboleggia fiducia, ottimismo e buonumore","Italia", 35.0, 16, 1,"Svilluppo sostenibile" );
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Arancio", "Medicina");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Arancio", "Recinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Arancio", "Suolo");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Arancio", "Sviluppo economico");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Arancio", "Sicurezza alimentare");

/*Avocado*/
INSERT INTO albero (nome, co2, descrizione, descrizione_breve, prezzo, salvaguardia, specie_scientifica, categoria, paese_origine) VALUES ("Avocado", 500,"L''Avocado è principalmente conosciuto per i suoi frutti altamente energetici e ricchi di nutrienti. L''olio estratto dal frutto è usato nella cosmesi per le sue proprietà antiossidanti e rivitalizzanti, mentre le foglie hanno ottime proprietà cicatrizzanti. Viene piantato per la produzione di frutti e come albero da ombra per altre colture.","Anche le cose apparentemente amare nascondono un animo dolce.", 22.90, 4,"Persea americana", "Salvaguardia ambientale", "Perù");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Avocado", "Cosmesi");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Avocado", "Vendita");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Avocado", "Sicurezza alimentare");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Avocado", "Sviluppo economico");

/*Banano*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES ("Banano", "Musa x paradisiaca", "Il Banano è una pianta erbacea gigante della famiglia delle Musaceae, che può crescere fino a 6-7 m di altezza. Originario dell'Asia, viene coltivato principalmente nel Centro America, Africa Tropicale e Filippine. Fruttifica solo in climi tropicali e necessita di protezione dai venti. Viene piantato per l'uso alimentare e per la commercializzazione dei suoi frutti.","Fantasie. Chiamato dagli antichi Musa, il Banano è da sempre la più maliziosa tra le fonti d'ispirazione", "Perù",24.90, 48, 5, "Rischio estinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Banano", "Allevamento");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Banano", "Antivento");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Banano", "Insetticida");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Banano", "Sicurezza alimentare");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Banano", "Sviluppo economico");

/*Baobab*/
INSERT INTO albero (nome, co2, descrizione, descrizione_breve, prezzo, salvaguardia, specie_scientifica, categoria, paese_origine) VALUES ("Baobab", 3000,"Il Baobab è una specie originaria del Madagascar e diffusa in tutta l''Africa. Celebre per la sua imponenza, pensate che il diametro del tronco può arrivare a 10 metri. È considerato il centro gravitazionale della vita sociale dei villaggi, sotto la sua ombra si tengono mercati, riunioni, danze e giochi. Viene piantato per contribuire al recupero delle foreste naturali.","È un albero magico e senza tempo: per la sua longevità, nella tradizione popolare africana è chiamato Albero della Vita.", 59.90, 4,"Adansonia", "Rischio estinzione", "Argentina");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Baobab", "Medicina");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Baobab", "Recinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Baobab", "Vendita");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Baobab", "Protezione ambientale");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Baobab", "Assorbimento di Anidride Carbonica");

/*Cacao*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES ("Cacao", "Theobroma cacao","Il Cacao è un sempreverde che produce piccoli fiori a cinque petali, bianchi, verdi o rosei, che spuntano direttamente sul tronco o sui rami principali; i fiori più fortunati si trasformano nei celebri frutti. Viene piantato per la produzione di cacao di ottima qualità e per offrire ai contadini locali una fonte di reddito aggiuntiva.", "Dolcezza! Anche le cose apparentemente amare nascondono un animo dolce.", "Guatemala", 20.00, 24, 5, "Rischio estinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Cacao", "Vendita");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Cacao", "Cosmesi");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Cacao", "Sicurezza alimentare");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Cacao", "Sviluppo economico");

/*Caffe*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES ("Caffe","Coffea arabica","Il Caffè, dai cui semi si ricava l’omonima bevanda, appartenente alla famiglia delle Rubiaceae. Sebbene ne esistano oltre 100 specie, come ci confermano gli scaffali dei supermercati, le più diffuse sono l'arabica e la robusta. Il caffé rappresenta un'importante fonte di reddito per le comunità locali.","Energia! Il Caffè, dai cui semi si ricava l’omonima bevanda, appartenente alla famiglia delle Rubiaceae. Sebbene ne esistano oltre 100 specie, come ci confermano gli scaffali dei supermercati, le più diffuse sono l'arabica e la robusta. Il caffé rappresenta un'importante fonte di reddito per le comunità locali.", "Guatemala", 24.90,13,5, "Rischio estinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Caffe", "Cosmesi");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Caffe", "Vendita");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Caffe", "Sicurezza alimentare");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Caffe", "Sviluppo economico");

/*Carbonero*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Carbonero","Calliandra carbonaria","Originaria delle montagne del Sud America, questa specie molto speciale di calliandra è diffusa dal Venezuela al Perù. Il 'carbonero', come viene chiamato localmente, cattura immediatamente l'attenzione: grazie alla sua infiorescenza a forma di testa coperta da molti stami rossi, è impossibile non notarlo. Le calliandre sono arbusti decidui o piccoli alberi che producono baccelli a forma di mezzaluna. Nonostante questa 'produttività', vengono anche piantate come alberi di sostegno per fornire ombra o migliorare il suolo.","Notturno! Come molte altre specie di calliandra, le foglie del carbonero si muovono autonomamente. Questa condizione prende il nome di 'movimenti del sonno'. Di notte le foglie si chiudono, mentre durante il giorno si aprono.", "Argentina", 34.50, 45, 5,"Salvaguardia ambientale");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Carbonero", "Antivento");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Carbonero", "Suolo");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Carbonero", "Allevamento");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Carbonero", "Sicurezza alimentare");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Carbonero", "Sviluppo economico");

/*Castagno*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Castagno","Castanea sativa","Il Castagno è uno degli alberi che ha intrecciato profondamente la propria storia con quella degli esseri umani. Si ritiene che sia originario del Caucaso e che da lì sia stato propagato in Europa dai Greci prima e dai Romani poi. Diffuso e curato per i suoi frutti, le castagne, ed il suo legname, a partire dal XV secolo è iniziato il suo declino. Ma se la sua coltivazione è oggi ridotta, la sua importanza nella cultura di molti popoli europei rimane assolutamente centrale. Questo castagno verrà piantato nel progetto che abbiamo avviato nel cuore dei uno dei castagneti più antichi d'Europa, che si trova nel sud della Toscana e che vogliamo far crescere rigoglioso come un tempo.","Amicizia! La storia del Castagno è la storia di una lunga amicizia fra alberi ed esseri umani. Un'amicizia da riscoprire e ... coltivare.", "Italia", 45, 50, 4, "Svilluppo sostenibile");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Castagno", "Cosmesi");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Castagno", "Vendita");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Castagno", "Allevamento");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Castagno", "Sicurezza alimentare");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Castagno", "Sviluppo economico");

/*Grevilea*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Grevilea","Grevillea robusta", "La Grevillea robusta raggiunge altezze di 12- 25 metri; i fiori sono di un giallo vistoso e ricchi di un nettare che attrae le api stimolandone l’integrazione con l’ecosistema e favorendo l’impollinazione delle piante. Viene utilizzata anche come pianta frangivento e consente la formazione naturale di humus mantenendo l’umidità e migliorando la qualità del suolo.","Pazienza! Piantato spesso a bordo strada, questo albero sopporta anche il traffico dell'ora di punta.", "Perù", 34.90, 56,2, "Salvaguardia ambientale");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Grevilea", "Vendita");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Grevilea", "Insetticida");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Grevilea", "Sicurezza alimentare");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Grevilea", "Protezione ambientale");

/*Limone*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES ("Limone", "Citrus aurantiifolia (Christm.)", "Secondo alcuni studi genetici, probabilmente il Limone è un antico ibrido tra pompelmo e cedro. Questo agrume produce bellissimi fiori dai petali bianchi e violetti, e profumatissimi frutti. Il commercio di limoni aiuta le popolazioni migliorandone la qualità di vita.", "Brividi!! Non sempre è buono ciò che è dolce: il limone ad esempio è amato proprio per i brividi suscitati dalla sua acidità...", "Guatemala", 17.00, 3, 4,"Salvaguardia ambientale" );
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Limone", "Suolo");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Limone", "Insetticida");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Limone", "Antivento");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Limone", "Assorbimento di Anidride Carbonica");

/*Longan*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Longan", "Dimocarpus longan", "Il Longan è un albero tropicale dalla chioma folta voluminosa, che può crescere fino a 12 metri d’altezza. Teme il gelo e cresce bene su terreni sabbiosi. Produce frutti commestibili simili a quelli del Litchi (albero della stessa famiglia del Longan, quella delle Sapindaceae). È originario della Cina e oggi lo si trova anche in buona parte del sudest asiatico ed anche in Australia. In tutti questi paesi i suoi frutti trovano impiego in vari usi alimentari: possono essere consumati freschi, cucinati in vari modi (dalle zuppe ai dessert) ed anche essiccati. Sono inoltre utilizzati nella medicina tradizionale cinese.", "Fantasy! Il suo nome, in cinese, significa esattamente “occhio di drago”. Questo è dovuto al fatto che i suoi frutti, liberati dalla leggera scorza che li protegge, hanno una polpa quasi trasparente, attraverso cui è facile intravedere il grosso seme scuro all’interno. Una forma che può essere immaginata come il bulbo oculare … di un drago!", "Perù", 45.70,  34,3, "Salvaguardia ambientale");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Longan", "Recinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Longan", "Vendita");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Longan", "Suolo");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Longan", "Sviluppo economico");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Longan", "Assorbimento di Anidride Carbonica");

/*Mandarino*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Mandarino", "Citrus reticulata", "Originario della Cina, dalle foglie piccole e profumate, il Mandarino produce frutti dolci e aromatici. Un albero adulto può dare dai 400 ai 600 frutti all’anno e viene ovviamente piantato per uso alimentare e per incrementare il reddito agricolo locale grazie alla vendita dei frutti.", "Profumo! I frutti di Mandarino, ed in particolare la loro buccia, emanano un profumo agrodolce e inebriante.","Italia", 24.90,65,5, "Rischio estinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Mandarino", "Cosmesi");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Mandarino", "Vendita");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Mandarino", "Sviluppo economico");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Mandarino", "Protezione ambientale");

/*Mango*/
INSERT INTO albero (nome, co2, descrizione, descrizione_breve, prezzo, salvaguardia, specie_scientifica, categoria, paese_origine) VALUES ("Mango", 700,"Il Mango prospera in zone tropicali e subtropicali. In pochi sanno che è in grado di raggiungere i 45 metri di altezza e produrre una gran quantità di frutti che possono essere mangiati freschi oppure lavorati ed impiegati in numerosissime ricette. Viene piantato proprio per offrire frutti alla popolazione locale, sia da consumare che da commerciare.","L'albero della felicità. Per colore, profumo e gusto, il mango è il frutto del sole e della gioia.", 29.90, 4,"Mangifera indica", "Salvaguardia ambientale", "Italia");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Mango", "Recinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Mango", "Insetticida");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Mango", "Sicurezza alimentare");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Mango", "Protezione ambientale");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Mango", "Assorbimento di Anidride Carbonica");

/*Mangrovia nera*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Mangrovia Nera", "Avicennia germinans", "La Mangrovia Nera può presentarsi come un arbusto sempreverde o un albero di piccole e medie dimensioni, con una corona arrotondata di rami sparsi. Di solito cresce dai 3 ai 12 metri di altezza, ma occasionalmente raggiunge i 25 metri. Crescendo nelle distese fangose mareali, la pianta ha sviluppato un apparato radicale con molte radici respiratorie verticali, sopra il livello del suolo.","Abbraccio! Le sue radici, che sembrano tante braccia che formano un reticolo, offrono riparo a tante specie di pesci e frenano l'erosione dei terreni a causa delle maree. L'abbraccio della Mangrovia è davvero prezioso.", "Guatemala", 65.90, 65, 4, "Rischio estinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Mangrovia Nera", "Cosmesi");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Mangrovia Nera", "Vendita");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Mangrovia Nera", "Sviluppo economico");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Mangrovia Nera", "Protezione ambientale");

/*Melograno*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Melograno","Punica granatum","Si ritiene che il Melograno sia originario dell'Asia sud-occidentale. La sua coltivazione è conosciuta sin da tempi lontanissimi ed i suoi frutti così particolari hanno affascinato le popolazioni più diverse, dai Fenici agli Armeni, che hanno immaginato storie e leggende per raccontarne la nascita. Anche i suoi fiori, dal calice carnoso e dal colore rosso intenso, sono di rara bellezza. Coltivato ad albero, il Melograno può raggiungere i 7 metri d’altezza. Ha radici molto forti che affondano in profondità, rendendolo assai resistente alla siccità. Questo melograno sarà piantato da una cooperativa agricola sociale e biologica che lavora su terreni confiscati alla criminalità organizzata.","Prosperità! I suoi fiori carnosi, i suoi frutti rigogliosi, il colore rosso dei loro chicchi, la loro parte polposa e succosa; non è un caso che per tante culture il Melograno sia stato associato alla prosperità.", "Italia", 56.90, 46, 4,"Svilluppo sostenibile");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Melograno", "Suolo");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Melograno", "Recinzione");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Melograno", "Protezione ambientale");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Melograno", "Assorbimento di Anidride Carbonica");

/*Neem*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Neem", "Azadirachta indica","Nativo dell'India e della Birmania, il Neem è un albero sempreverde che può arrivare fino a 30 m di altezza. Viene usato come ombreggiante, grazie alla sua folta chioma, e come barriera anti-desertificazione, soprattutto nelle regioni sahariane. Ma la sua peculiarità è soprattutto quella che raccontata dal suo nome in Sanscrito: Sarva roda nidarini, il guaritore di tutti i malanni. Gli usi che si possono fare di ogni parte di questo albero, dalla corteccia alle foglie, sono pressoché infiniti.", "Futuro! L'ONU l'ha definito l'albero del secolo", "Perù", 45.90, 43,4,"Rischio estinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Neem", "Antivento");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Neem", "Suolo");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Neem", "Sviluppo economico");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Neem", "Assorbimento di Anidride Carbonica");

/*Nespolo */
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Nespolo", "Eriobotrya japonica", "Il nespolo del Giappone è una pianta appartenente alla famiglia delle Rosaceae. Viene coltivata a scopo commerciale per il suo frutto, e anche come ornamentale. Non va confuso con la nespola comune o germanica, di più antica coltivazione in Europa, che è invece il frutto di un'altra rosacea, il nespolo europeo (Crataegus germanica), oggi raramente coltivata e commercializzata.", "Gioa! Quando il Nespolo del Giappone fiorisce la sua ampia chioma si punteggia di splendidi fiori bianchi dal profumo dolce e intenso. Dolcezza e intensità che è la stessa dei frutti quando sono maturi. Una vera gioia per i sensi.","Italia",45.90,67,3,"Svilluppo sostenibile");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Nespolo", "Antivento");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Nespolo", "Vendita");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Nespolo", "Suolo");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Nespolo", "Protezione ambientale");

/*Papaya*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Papaya","Carica papaya","La Papaya è un piccolo sempreverde che può raggiungere i 10 metri di altezza. Il tronco contiene un succo lattiginoso, composto da papaina, usato soprattutto per scopi medicinali. Questo albero deve essere coltivato in zone calde al riparo dal vento e quindi spesso viene coltivato in coltura consociata con altri arbusti di dimensioni maggiori, con lo scopo di venderne i frutti e farne ottimi succhi di frutta.","Ammaliante!! I semi della Papaya hanno un sapore che, specie all’inizio, potrebbe non piacere a tutti. Ricordano la senape e sono leggermente piccanti, ma usati in piccole dosi per arricchire di sapori i piatti giusti, sanno essere ammalianti come poche altre spezie.", "Guatemala", 24.90, 56,2, "Svilluppo sostenibile");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Papaya", "Cosmesi");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Papaya", "Vendita");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Papaya", "Protezione ambientale");

/*Pino Di Aleppo*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES ("Pino", "Pinus halepensis","Il pino di Aleppo è tipico della regione mediterranea, tipicamente lo si trova in prossimità della costa, anche se nel tempo il suo areale è andato crescendo ed oggi si possono trovare pini di Aleppo anche oltre i 600 metri di altitudine. Questo albero, che cresce fino a 15 metri di altezza, si riconosce dai suoi aghi grigio-verdi, sottili, che possono essere lunghi fino a 10 cm e sono raggruppati in due sui germogli. Le piccole pigne bruno-rossastre sono simili a quelle di altri pini silvestri. La sua resina ha sentori molto caratteristici ed è utilizzata ampiamente sin dall'antichità.", "Inconfondibile! Avete mai provato il vino Retsina? Un vino greco a cui si aggiunge la resina... è la resina del pino di Aleppo. Gli dà l'inconfondibile sapore amaro.", "Italia", 69.00, 90, 4,"Rischio estinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Pino", "Medicina");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Pino", "Suolo");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Pino", "Sicurezza alimentare");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Pino", "Sviluppo economico");

/*Pomelo*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Pomelo","Citrus maxima", "Albero che cresce dai 5 ai 10 metri, anche se in alcuni casi può raggiungere i 15, il Pomelo è famoso per i suoi frutti, capaci di misurare fino a 30 cm di diametro e pesare fino a 2 Kg. Hanno una forma che ricorda più quella di una pera che di un agrume ed in media una pianta che vive in condizioni ideali, può produrne anche 100 all’anno.", "Originalità!! Il Pomelo, insieme al Mandarino e al Cedro, è conosciuto come una delle 3 specie da cui derivano tutti gli agrumi conosciuti.","Guatemala", 30.00, 78, 3,"Salvaguardia ambientale");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Pomelo", "Cosmesi");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Pomelo", "Vendita");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Pomelo", "Suolo");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Pomelo", "Sicurezza alimentare");

/*Quercia*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Quercia", "Quercus coccifera", "La Quercia Spinosa è un arbusto sempreverde e di solito raggiunge un'altezza di circa 3 metri. Con la sua corteccia grigia chiara e liscia, è facile da distinguere dalle altre querce. Le sue foglie di fogliame verde scuro sono lunghe fino a 5 cm. Con il tempo, alcuni dei fiori formano i frutti caratteristici della Quercia Spinosa. La sua gamma si estende su quasi tutta la regione mediterranea. Viene coltivato principalmente per i suoi frutti, che possono essere mangiati arrostiti, per esempio. Questa Quercia spinosa verrà piantata in provincia di Lecce grazie alla collaborazione con una Fondazione locale impegnata ad espandere la superficie boschiva e avviare alla rinaturalizzazione terreni abbandonati.","Protezione! Un albero che sa come proteggere se stesso e i suoi frutti: i suoi frutti sono coperti da spine corte e sporgenti. Le sue foglie sono anche spinose-dentate.", "Italia", 69.90, 67, 4, "Salvaguardia ambientale");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Quercia", "Medicina");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Quercia", "Suolo");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Quercia", "Sviluppo economico");

/*Vite*/
INSERT INTO albero (nome, specie_scientifica, descrizione, descrizione_breve, paese_origine, prezzo, co2,salvaguardia, categoria) VALUES("Vite","Vitis vinifera","La vite è un arbusto rampicante e la sua forma viene determinata dal tipo di allevamento con cui viene gestita da chi la coltiva. Esistono numerosissime varietà di vite e ciascuna ha specifiche caratteristiche rispetto alle foglie, ai fiori e soprattutto ai frutti; quell’uva che può avere forme, colori e sapori assai diversi fra loro. La storia della vite si è da millenni intrecciata a quella dell’uomo, che oggi la coltiva in tutti i continenti (con l’eccezione dell’Antartide per ovvi motivi climatici) e ne consuma i frutti sia freschi che lavorati, soprattutto nella forma di quella bevanda nota a chiunque come: vino. Questa vite sarà piantata in Campania in un progetto di recupero di aree confiscate alla criminalità organizzata.", "Euforia! Il vino è una bevanda alcolica ottenuta dalla fermentazione dell’uva, frutto della vite. Nella sua lunga storia il vino si è caricato di numerosi significati simbolici e di profondi portati culturali, tuttavia è innegabile che tra i motivi del suo successo via sia anche quella sensazione magica di euforia che sa donare a chi ne fa un giusto (e moderato) consumo.", "Italia", 70.90, 10, 2,"Rischio estinzione");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Vite", "Cosmesi");
INSERT INTO albero_usi_locali (albero_nome, usi_locali_nome) VALUES ("Vite", "Vendita");
INSERT INTO albero_benefici (albero_nome, benefici_nome) VALUES ("Vite", "Sviluppo economico");