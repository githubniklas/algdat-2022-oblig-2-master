# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Niklas Laache, S362125, s362125@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Niklas har hatt hovedansvar for oppgave 1, 2, 3, 4, 5, 6, 8.

# Oppgavebeskrivelse

I Oppgave 1 gikk jeg frem ved å returnere antallet i antall() og legge inn en if/else test som returnere true eller false i boolean tom(). Deretter lagde jeg konstruktøren DobbeltLenketListe(T[] a), som har 3 if-tester, første sjekker om a er null og kaster unntak. Andre er en if-test som kjører dersom lengden til a er større enn null, og kjører dermed en for-løkke som finner første element som ikke er null. Og lager en node. Deretter kommer en if-test, så en for-løkke som itererer gjennom listen og en if-test som lager resten av listen dersom hode ikke er null.

I Oppgave 2 gikk jeg frem ved å lage metoden toString() første if-testen returnerer en ] dersom listen er tom. Det kommer deretter en else som kjører dersom listen ikke er tom og legger til verdien i stringbuilder med hjelp av en while-løkke. Det samme skjer i metoden omvendtString() bare at den går fra hale til hode, i motsetning tiol toString() som går fra hode til hale.

I Oppgave 3 a) gikk jeg frem ved å først lage en Objects.requireNonNull som sjekker om det er null verdier i listen. Deretter en if-test som kjører dersom listen er tom og setter båre hode og hale lik null. Deretter kommer en else dersom listen ikke er tom, der hale-pekeren endres. Variablene antall og endringer økes etter en innlegging skjes. Begge metodene returnerer true.

I Oppgave 4 gikk jeg frem ved å implementere hjelpemetoden Node<T> finnNode(int indeks). Først kommer en if-test som sjekker om indeks er større enn antall delt på to. Deretter starter letingen ved hjelp av en for-løkke og neste pekere og returnerer den nåverende noden. Deretter kommer en else dersom indeks ikke er størr enn antall delt på to. Her starter letingen fra hale og går mot venstre ved hjelp av forrige pekere, metoden returnere dermed noden.

Deretter implementerte jeg metoden T hent(int indeks) der indeks sjekkes ved hjelp av indeksKontroll() og finnNode() brukes her.

Deretter implementerte jeg metoden T oppdater(int indeks, T nyverdi) som erstatter verdi på plassen indeks med nyverdi og returnerer den gamle verdien.

I Oppgave 3 b) gikk jeg frem ved å legge inn hjelpemetoden fratilKontroll() som en privat metode. Og bruker denne i metoden subliste(int fra, int til). Starter med en if-test dersom lengden er mindre enn 1 og returnerer den. Deretter kommer en while-løkke som legger inn verdiene til listen, og dermed returnerer den.

I Oppgave 4 gikk jeg fram ved å lage metoden int indeksTil(T verdi) denne metoden returnerer første forekomst av verdi, og hvis den ikke finnes blir -1 returnert. Her blir det brukt en while-løkke som kjører dersom current ikke er null, og en if test som gjøre om funnet til true. Deretter returneres den første verdien. Deretter implementerte jeg metoden boolean inneholder(T verdi) som returnerer true dersom listen inneholder verdi og returnerer false dersom den ikke gjør det.

I Oppgave 5 gikk jeg frem ved å implementere metoden void leggInn(int indeks, T verdi) starter først med å sjekke om det er Null-verdier, deretter blir indeksen sjekket med indeksKontroll. Deretter kommer 4 if/else-if/else tester som bestemmer hvor verdi skal legges inn, dersom antall er 0, indeks er 0, eller dersom indeks er lik antall. Deretter blir antall og endringer økt. 

I oppgave 6 gikk jeg fram ved å lage metoden T fjern(int indeks) metoden starter med en if-test som sjekker om det bare er en node i listen og fjerner den. Deretter en else-if som fjerner den første, neste else-if fjerner den siste og til slutt kommer en else som fjerner det imellom. Antall minker og endringer øker. Deretter implementerte jeg metoden boolean fjern(T verdi). Denne starter med en if-test som sjekker om verdi er null og returnerer false. Deretter kommer en while-løkke som leter etter verdien. Så kommer en if test som sjekker om current er null og returnerer false, så en else-if test som setter hode og hale til null dersom det bare er en node. Så kommer en else-if test som fjerner den første, etter det kommer en else-if som fjerner den siste. Og en else som fjerner det imellom. Antall minker og endringe øker, og returnerer true dersom fjerningen funket.

I Oppgave 8 a) gikk jeg frem ved å implementere metoden T next(), la først inn en if test som sjekker om iteratorendriner ikke er lik endringer og kaster dermed et unntak. Etter det kommer en if-test som sjekker om hasNext() er usann og kaster et unntak dersom det er det. Etter det blir verdien til denne tatt vare på returnert og denne blir flyttet til neste node.

I Oppgave 8 b) Gikk jeg frem ved å lage metoden Iterator<T> iterator() denne returnerer en instans av iteratorklassen.

I Oppgave 8 c) gikk jeg frem ved å lage konstruktøren private DobbeltLenketListeIterator(int indeks) her blir pekeren denne satt til den noden som hører til indeksen. 

I Oppgave 8 d) gikk jeg frem ved å lage metoden Iterator<T> iterator(int indeks), her blir det tatt en indekskontroll av indeksen og deretter blir det returnert en instans av iteratorklassen.

Oppgave 8 (NB) Testen for oppgave 8 feiler ettersom at nullstill() ikke er laget fra oppgave 7. Kommenterte ut testene og sjekket på nytt uten dem og det funket.
