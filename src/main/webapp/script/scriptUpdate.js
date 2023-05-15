
function createInput(type, name, value, hidden) {
    let input = document.createElement("input");
    input.setAttribute("type", type);
    input.setAttribute("name", name);
    input.setAttribute("value", value);
    input.style.borderRadius = "8px";
    input.style.border = "1px solid black";
    if (hidden) {
        input.setAttribute("hidden", "hidden");
    }
    return input;
}

function switchMode(id) {
    const myCard = document.getElementById("myCard" + id);
    const myCardBody = document.getElementById("myCardBody" + id);

    myCard.removeChild(myCardBody);

    let myNewCardBody = document.createElement("div");
    myNewCardBody.classList.add("card-body");
    myNewCardBody.setAttribute("id", "myCardBody" + id);

    let myForm = document.createElement("form");
    myForm.setAttribute("method", "post");
    myForm.setAttribute("action", "updateProduct");
    myForm.classList.add("form_update");

    let inputName = createInput("text", "recipe_name", myCardBody.firstElementChild.innerHTML);
    let inputIngredient = createInput("text", "recipe_ingredient", myCardBody.children[1].innerHTML);
    let hiddenInput = createInput("text", "recipe_id", id, true);

    let confirmButton = document.createElement("button");
    confirmButton.setAttribute("type", "submit");
    confirmButton.classList.add("btn", "btn-info", "button-update");
    confirmButton.textContent = "Confirmer";

    myForm.appendChild(inputName);
    myForm.appendChild(inputIngredient);
    myForm.appendChild(hiddenInput);
    myForm.appendChild(confirmButton);

    myNewCardBody.appendChild(myForm);

    myCard.appendChild(myNewCardBody);
}








