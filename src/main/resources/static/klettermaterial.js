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
    jQuery.get('seile/' + index)
        .then(seile =>{
        console.log(seil);
    }).catch(error=>{
    console.log(error);
});
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




}
