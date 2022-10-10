package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }


    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    //Tom liste konstruktør
    public DobbeltLenketListe() {
        hode = null;
        hale = null;

        antall = 0;
        endringer = 0;
    }

    //Konstruktør
    public DobbeltLenketListe(T[] a) {
        if (a == null) {                                                        //if-test som sjekker om a er null og thrower en exception.
            throw new NullPointerException("Tabellen a er null!");
        }
        int i = 0;
        if (a.length > 0) {
            for (; i < a.length; i++) {                                         //for-løkke som finner første element som ikke er null og lager en node.
                if (a[i] != null) {
                    hode = new Node<>(a[i]);
                    antall++;
                    break;
                }
            }
        }
        hale = hode;

        if (hode != null) {                                                     //if-test som lager resten av listen.
            i++;
            for (; i < a.length; i++) {
                if (a[i] != null) {
                    hale.neste = new Node<>(a[i], hale, null);
                    hale = hale.neste;
                    antall++;
                }
            }
        }
    }

    public Liste<T> subliste(int fra, int til) {
        throw new UnsupportedOperationException();
    }

    private Node<T> finnNode(int indeks) {
        Node<T> current;

        if (indeks < antall/2) {                                                //leting starter fra hode dersom indeks er mindre enn antall/2
            current = hode;                                                     //og går mot høyre ved hjelp av neste-pekere
            for (int i = 0; i < indeks; i++) {
                current = current.neste;
            }
            return current;
        }
        else {                                                                  //leting starter fra hale dersom indeks ikke er mindre enn antall/2
            current = hale;                                                     //og går mot venstre ved hjelp av forrige-pekere
            for (int i = antall - 1; i > indeks; i--) {
                current = current.forrige;
            }
            return current;
        }
    }

    @Override                                                                   //metode som returnerer antallet verdier i listen
    public int antall() {
        return antall;
    }

    @Override                                                                   //metode som returnerer true/false dersom listen er tom eller ikke.
    public boolean tom() {
        if (hode == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean leggInn(T verdi) {
        Node<T> current = new Node<>(verdi);
        Objects.requireNonNull(verdi);                                          //requireNonNull sjekk for å finne ut om det er null verdier i listen.

        if (hale == null && hode == null && antall == 0) {                      //kjører dersom listen er tom.
            hode = current;
            hale = hode;
            antall++;
            endringer++;
            return true;
        }
        else {                                                                  //kjører dersom listen ikke er tom.
            current.forrige = hale;
            hale.neste = current;
            hale = current;
            antall++;
            endringer++;
            return true;
        }
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {throw new UnsupportedOperationException();}

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        Node<T> current = finnNode(indeks);
        return current.verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = hode;

        if (tom()) {                                                //returnerer [] dersom listen er tom
            sb.append("]");
            return sb.toString();
        }
        else {                                                      //kjører dersom listen ikke er tom
            sb.append(current.verdi);
            current = current.neste;

            while (current != null) {                               //while-løkke som legger til innholdet ved hjelp av stringbuilder
                sb.append(", ");
                sb.append(current.verdi);
                current = current.neste;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String omvendtString() {                                 //gjør det samme som toString(); bare at verdiene kommer i omvendt rekkefølge
        StringBuilder sb = new StringBuilder();                     //ved at den går fra hale til hode istedet.
        sb.append("[");
        Node<T> current = hale;

        if (tom()) {
            sb.append("]");
            return sb.toString();
        }
        else {
            sb.append(current.verdi);
            current = current.forrige;

            while (current != null) {
                sb.append(", ");
                sb.append(current.verdi);
                current = current.forrige;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


