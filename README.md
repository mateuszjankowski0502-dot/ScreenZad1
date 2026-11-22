\# Dwa Ekrany – aplikacja Android

 

\## Opis projektu



Aplikacja Android napisana w języku Java w Android Studio. Umożliwia wprowadzenie danych w formularzu, wyświetlenie ich na drugim ekranie, potwierdzenie zgłoszenia oraz udostępnienie podsumowania za pomocą intencji niejawnej.



## Funkcjonalności

 

\- Przejście z pierwszego ekranu na drugi za pomocą jawnej intencji.

\- Przekazywanie danych formularza przez `putExtra()`.

\- Odbieranie wyniku z drugiej aktywności za pomocą `ActivityResultLauncher`.

\- Potwierdzanie lub anulowanie zgłoszenia.

\- Udostępnianie podsumowania przez `Intent.ACTION\_SEND`.

 

\## Zrzuty ekranu



\### Ekran formularza



!\[Ekran formularza](screenshots/ekran-formularza.png)



\### Ekran podsumowania



!\[Ekran podsumowania](screenshots/ekran-podsumowania.png)



\## Odpowiedzi na pytania

 

\### 1. Dlaczego rejestrację ActivityResultLauncher wykonujemy jako pole klasy, a nie wewnątrz obsługi kliknięcia przycisku?



ActivityResultLauncher powinien zostać zarejestrowany przed uruchomieniem aktywności, zgodnie z cyklem życia Androida. Rejestracja jako pole klasy pozwala zachować prawidłową kolejność rejestracji i umożliwia systemowi poprawne dostarczenie wyniku. Rejestrowanie go dopiero po kliknięciu przycisku może spowodować błąd związany z cyklem życia aktywności.



\### 2. Co widzi pierwszy ekran, gdy użytkownik naciśnie Wstecz na drugim ekranie?



Naciśnięcie przycisku Wstecz zamyka drugą aktywność. Pierwsza aktywność otrzymuje wynik `RESULT\_CANCELED`, ponieważ druga aktywność nie zwróciła wyniku `RESULT\_OK`. Użytkownik wraca do formularza, a zgłoszenie nie zostaje potwierdzone.


\## Technologie

 

\- Java

\- Android Studio

\- Android SDK

\- Intents

\- ActivityResultLauncher

\- XML

# MenuZad2
