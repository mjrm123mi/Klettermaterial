/*
    private String hersteller;
    private String modell;
    private String typ;
    private double durchmesser;
    private int laengeInMetern;
    private String herstellungsdatum;
    private String ablaufdatum;

 */

function postOneRandomSeil(){
    const seil = {hersteller: "Petzl", modell: "DynamoXC", typ: "Einfachseil", durchmesser: 7.8, laengeInMetern: 100, herstellungsdatum: "01.01.2020", ablaufdatum: "01.01.2030"};

$.ajax({
    url: "/seile",
    method: "POST",
    contentType: "application/json; charset=UTF-8",
    data: JSON.stringify(seil),
    dataType: "json"
}).then(index => {
    console.log(index);
}).catch(error => {
    console.log(error);
});
}

window.onload = function (){
    console.log('POST ENDE');
    for(let i = 0; i < 12; ++i){
        postOneRandomSeil();
    }
    console.log('POST ANFANG');



    console.log('GET ANFANG');
    jQuery.get('/seile').then(seile => {
        for (const seil of seile) { // ab hier checken ob rest richtig
            console.log(`Das Seil mit der ID ${seil.id} läuft am ${seil.ablaufdatum} ab`);
        }
    }).catch(error => {

        console.log(error);

    });

    window.onload = function () {
        console.log('GET ENDE');
        for (let i = 0; i < 12; ++i) {
            postOneRandomSeil();
        }
        console.log('POST ANFANG');
        jQuery.get('seile').then(seile => {
            for (const book of books) {
                console.log(`${seil.modell} wurde von ${seil.hersteller} hergestellt`);
            }
        }).catch(error => {
            console.log(error);
        });
        console.log('GET ENDE');
    }

}
