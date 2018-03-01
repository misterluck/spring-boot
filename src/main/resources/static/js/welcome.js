var websocket = null;

function connect() {
    var username = $('#username').val();
    if (username != null && username != "") {
        if ('WebSocket' in window) {
            websocket = new WebSocket("ws://localhost:8080/websocket/"+$("#username").val());
        }else if('MozWebSocket' in window) {
            websocket = new MozWebSocket("ws://localhost:8080/websocket/"+$("#username").val());
        }else {
            alert("该浏览器不支持websocket");
        }

        websocket.onopen = function (message) {
            alert("连接成功"+message);
        }

        websocket.onmessage = function (message) {
            alert(message);
        }

        websocket.onclose = function (message) {
            alert("连接中断" + message);
        }

    }else {
        alert("请输入您的昵称!");
    }

}

function sendMessage() {
    websocket.send($("#message").val());
}