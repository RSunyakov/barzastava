var form  = document.getElementsByTagName('form')[0];
var email = document.getElementById('inputEmail');
var error = document.getElementById("emailError");
var password = document.getElementById("inputPassword").value;
var repeatPassword = document.getElementById("inputRepeatPassword");
var errorPassword = document.getElementById("errorPassword");
var name = document.getElementById("inputName").value;
var errorName = document.getElementById("errorName");
var genderFemale = document.getElementById("inputGenderFemale").value;
var genderMale = document.getElementById("inputGenderMale").value;
var accepted = document.getElementById("checkAccepted").value;

email.addEventListener("input", function (event) {
    if (email.validity.valid) {
        error.innerHTML = "";
    } else {
        error.innerHTML = "Неверный e-mail";
    }
}, false);
repeatPassword.addEventListener("input", function (ev) {
    password = document.getElementById("inputPassword").value;
    repeatPassword = document.getElementById("inputRepeatPassword");
    if ((repeatPassword.value.localeCompare(password)) === 0) {
    errorPassword.innerHTML = "";
    } else {
        errorPassword.innerHTML = "Пароли не совпадают"
    }
}, false);
form.addEventListener("submit", function (event) {
    password = document.getElementById("inputPassword").value;
    repeatPassword = document.getElementById("inputRepeatPassword");
    name = document.getElementById("inputName").value;
    genderFemale = document.getElementById("inputGenderFemale").value;
    genderMale = document.getElementById("inputGenderMale").value;
    accepted = document.getElementById("checkAccepted").checked;
    if (!email.validity.valid) {
        error.innerHTML = "Неверный e-mail";
        event.preventDefault();
    }
    if ((password === '')) {
        errorPassword.innerHTML = "Неверный пароль";
        event.preventDefault();
        return false;
    }
    if ((password.localeCompare(repeatPassword.value)) !== 0) {
        errorPassword.innerHTML = "Пароли не совпадают";
        event.preventDefault();
        return false;
    }
    if (name === "") {
        errorName.innerHTML = "Имя пользователя не должно быть пустым";
        event.preventDefault();
        return false;
    }
    if (!accepted) {
        alert("Нужно согласиться на обработку данных!")
        event.preventDefault();
        return false;
    }
}, false);