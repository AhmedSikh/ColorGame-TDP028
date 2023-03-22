# TDP028

* En kortversion av app-beskrivningen:
    Color game är en app som riktar mot barn. Appen är ett färgspel där barn kommer lära sig färgerna först genom att visa de färgerna med namnet bredvid de. Efter att barnet blir klar med inlärningen så kan de hoppa till själva spelet genom att klicka på "PLAY NOW" knappen, om barnen trycker på rätt färg så vinner barnet och i så fall appen går vidare till nästa färg, barnen kommer märka att den har vunnit en färg genom att spela ljud i bakgrunden med ordet "Happy" som passar barn. Om barnet lyckade svara rätt på sista färgen då visar skärmen en stor bild till barnet med en annan ljudeffekt i bakgrunden för att visa att spelet är slut samt att barnet har vunnit på de alla frågor som finns. Appen kan köras med flera språk beror på androidsystemets språk (Engelska/Svenska/Arabiska). Appen har flera verktyg till som ligger i Settings som kan bestämmas av, exempelvis användaren kan bestämma om hen vill ha mörkläge eller inte, samt välja små eller stor font-storlek.


* Min betygsambition:
Jag satsar på betyg 4 i kursen. (Uppdatering: Jag har kommit till betyg 4)


* Lista på alla poänggivande krav som jag har uppfyllt: (13P)

    * Lista på milstolpar som är uppfyllda: Summa = 3P
        - Milstolpe-1 2021-09-02 (0.5P)
        - Milstolpe-2 2021-09-03 (0.5P)
        - Milstolpe-3 2021-09-15 (0.5P)
        - Milstolpe-4 2021-09-23 (0.5P)
        - Milstople-5 2021-09-30 (0.5P)
        - Milstople-6 2021-11-26 (0.5P)


    * Tekniska krav: Summa = 6P
        - Hantering av bakåtknapp, så att man aldrig hamnar konstigt vid tryck på bakåtknappen. Detta sköts oftast automatisk av Android, men kan i vissa fall kräva hantering av vad som läggs på backstack. (1p)

        - Användande av egenskriven Adapter, eller motsvarande klass, t.ex. ViewModel, som ser till att matning av data till GUI:t sköts när användaren scrollar, etc., och att data-element formateras på ett snyggt sätt. I fallet av egen adapter, kan man t.ex. ärva från en ArrayAdapter och göra sin egen list-element formattering (dvs. override på superklassens metod för att ta fram en ny View att visa). (1p)

        - Hantering av skärmrotation. om enheten roteras ska skärminnehållet förbli stabilt. Samma innehåll visas som före rotationen, men nu med annan layout. Användarupplevelsen ska alltså bevaras, även om mobilen eller tablet:en roteras under körning. (OBS! 2p)

        - Hantering av stora och små skärmar med olika layouter. Användaren ska kunna byta från mobil till tablet utan att tappa i upplevelse. Bl.a. är det viktigt att information på skärmen förblir detsamma, samt att layout:en ser bra ut i båda lägen. Användarupplevelsen kan enkelt testas genom att rotera mobilen eller emulatorn före uppstart eller skapa emulatorn(tablet) som har stor skärm. (1p)

        - Bra avvägning mellan användning av Activity och Fragments. Best practices säger att man gärna ska använda Fragments där det går, då dessa är mer lättviktiga än Activities. Activities bör användas när det gäller byten mellan olika användaraktiviteter, t.ex. lista inkorg byts mot skriva mail. (1p)


    * Entreprenöriella krav: Summa = 4P
        - Någon typ av UX inställning, t.ex. möjlighet att ändra till dark mode (1P)

        - Multispråk-stöd (Engleska/Svenska/Arabiska). Använd Androids system för att göra så att Appen identiferar minst 2 språk och använder t.ex. Engelska som default och Svenska för användare med Svenska språkinställningar. (1P)

        - Notifications. Kan skicka notifications till användaren. Notifications möjliggör för appar att visa att något relevant finns. Implementera notifications för din app och testa att visa information även när appen inte är igång. (1P)

        - Någon form av accessibility stöd, t.ex. öka font-storlek. (1p)

    * Note: jag har samlat totalt 13p, Men jag vet inte faktiskt om jag har automatiskt samlat mer poäng än det som jag har skrivit ovan eller inte. Oavsett, jag tror inte att de kommer vara räckande för betyg 5.


* Tekniskt PM finns i : https://gitlab.liu.se/ahmsi881/tdp028/-/blob/main/Docs/Tekniskt%20PM.pdf


* Två stycken screencasts: 

    - en app-demo: https://gitlab.liu.se/ahmsi881/tdp028/-/blob/main/Screencasts/app-demo.mp4?expanded=true&viewer=rich

    - en kodgenomgång: https://gitlab.liu.se/ahmsi881/tdp028/-/blob/main/Screencasts/kodgenomg%C3%A5ng.mp4