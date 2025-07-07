window.onload = function () {
    console.log('GET ANFANG');

    jQuery.get('/seile').then(seile => {

        for (const seil of seile) {
            console.log(`Das Seil mit der ID ${seil.id} läuft am ${seil.ablaufdatum} ab`);
        }
    }).catch(error => {

        console.log(error);

    });

    console.log('GET ENDE');


    console.log('POST ANFANG');

    const seil = {id: "id", modell: "modell", typ: "typ"};

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

    console.log('POST ENDE');
}
