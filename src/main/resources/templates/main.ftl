<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script>
    function getDay() {
        $.ajax({
            type: 'get',
            url: '/page/' + $("#page").val() + '/user/' + $("#userId").val()
        }).done(function (data) {
            $("#dayView").empty();
            $("<h5>", {
                text: 'Всего пользователей: ' + data.all
        }).
            add($("<h5>", {
                text: 'Уникальных пользователей: ' + data.unique
        })).
            add($("<h5>", {
                text: 'Постоянных пользователей: ' + data.permanent
        })).appendTo("#dayView");
        })
    }

    function getInterval() {
        $.ajax({
            type: 'post',
            url: '/page/interval/',
            data:{
                start: $("#startDate").val() + 'T' + $("#startTime").val(),
                end: $("#endDate").val() + 'T' + $("#endTime").val()
            }
        }).done(function (data) {
            $("#intervalView").empty();
            $("<h5>", {
                text: 'Всего пользователей: ' + data.all
            }).
            add($("<h5>", {
                text: 'Уникальных пользователей: ' + data.unique
            })).
            add($("<h5>", {
                text: 'Постоянных пользователей: ' + data.permanent
            })).appendTo("#intervalView");
        })
    }
</script>
<body>

<h1>Создание события посещения сайта пользователем</h1>

<input type="text" id="page" placeholder="page name">
<input type="text" id="userId" placeholder="user id">
<button onclick="getDay()">Отправить</button>
<div id="dayView">

</div>

<h1>Получение статистики посещения за произвольный период</h1>
<h4>Начало</h4>
<input id="startTime" type="time">
<input id="startDate" type="date">
<h4>Конец</h4>
<input id="endTime" type="time">
<input id="endDate" type="date">
<button onclick="getInterval()">Отправить</button>
<div id="intervalView">

</div>
</body>
</html>