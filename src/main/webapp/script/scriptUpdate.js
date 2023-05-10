
function switchMode(id) {
    const myCard = document.getElementById("myCard" + id);
    const myCardBody = document.getElementById("myCardBody" + id);

    myCard.removeChild(myCardBody);

    let myNewCardBody = document.createElement("div");
    myNewCardBody.setAttribute("class", "card-body");
    myNewCardBody.setAttribute("id", "myCardBody" + id);

    let myForm = document.createElement("form");
    myForm.setAttribute("method", "post");
    myForm.setAttribute("action", "updateProduct");
    myForm.setAttribute("class", "form_update");

    let inputName = document.createElement("input");
    inputName.setAttribute("type", "text");
    inputName.setAttribute("name", "recipe_name");
    inputName.setAttribute("value", myCardBody.firstElementChild.innerHTML);

    let inputIngredient = document.createElement("input");
    inputIngredient.setAttribute("type", "text");
    inputIngredient.setAttribute("name", "recipe_ingredient");
    inputIngredient.setAttribute("value", myCardBody.children[1].innerHTML);

    let hiddenInput = document.createElement("input");
    hiddenInput.setAttribute("type", "text");
    hiddenInput.setAttribute("name", "recipe_id");
    hiddenInput.setAttribute("value", id);
    hiddenInput.setAttribute("hidden", "hidden");

    let confirmButton = document.createElement("button");
    confirmButton.setAttribute("type", "submit");
    confirmButton.setAttribute("class", "btn btn-info button-update");
    confirmButton.innerHTML = "Confirmer";

    myForm.appendChild(inputName);
    myForm.appendChild(inputIngredient);
    myForm.appendChild(hiddenInput);
    myForm.appendChild(confirmButton);

    myNewCardBody.appendChild(myForm);


    myCard.appendChild(myNewCardBody);
}

