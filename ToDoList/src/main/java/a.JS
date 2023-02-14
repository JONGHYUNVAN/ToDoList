function deleteItem(id){
    console.log(id)
    const url = "/"+id
    $.ajax({
        type:'delete',
        url:url,
        contentType:'application/json; charset=utf-8'
        }).done(function() {
        alert('Successfully Deleted');
        window.location.href = '/';
        }).fail(function (error){
        alert(JSON.stringify(error));
        });
}
function openModal(id){
    value = id
    $(".modal").fadeIn();
}

function reviseItem(){

    var id = value;
    console.log(id)
    var contentWritten = document.getElementById("revise").value;
    var updateContent = contentWritten;
    console.log(updateContent)
    const url = "/"+id;
     $.ajax({
        type:'put',
        url:url,
        contentType:'application/json; charset=utf-8',
        data: updateContent,
        }).done(function() {
        alert('Plan has been changed.');
        window.location.href = '/';
        }).fail(function (error){
        alert(JSON.stringify(error));
        });

     $(".modal").fadeOut();
}
function ExecuteClick(){
    var id = value;
    console.log(id)
    const url = "/done/"+id
     $.ajax({
        type:'delete',
        url:url,
        contentType:'application/json; charset=utf-8'
        }).done(function() {
        alert('Successfully Deleted');
        window.location.href = '/';
        }).fail(function (error){
        alert(JSON.stringify(error));
        });

        $(".modal").fadeOut();
}
function openModal(id){
    value = id
    $(".modal").fadeIn();
}