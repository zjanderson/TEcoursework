function sendRequest(accountNum) {
    fetch(`http://localhost:8080/account/${accountNum}/balance`, {
        method: 'POST',

    })
}

document.addEventListener('DOMContentLoaded', () => {
    const btnSendRequest = document.getElementById('btn-send-request');
    btnSendRequest.addEventListener('click', sendRequest);
})