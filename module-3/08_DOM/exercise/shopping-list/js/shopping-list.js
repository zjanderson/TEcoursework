// add pageTitle
const pageTitle = 'My Shopping List';

// add groceries -- might need to add 'completed' boolean, syntax , completed: false 
const groceries = [
  { id: 1, name: 'Chicken', completed: false},
  { id: 2, name: 'Lye', completed: false},
  { id: 3, name: 'Whiskey', completed: false},
  { id: 4, name: 'Pallet of Cabbage', completed: false},
  { id: 5, name: 'A Single Grape', completed: false},
  { id: 6, name: 'Live Salmon', completed: false},
  { id: 7, name: 'Slingshot', completed: false},
  { id: 8, name: 'GameStop Franchise', completed: false},
  { id: 9, name: 'Local Stream Detritus', completed: false},
  { id: 10, name: 'Flux Capacitor', completed: false}
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.getElementById('groceries');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    ul.appendChild(li);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  // const li = document.querySelectorAll('li');
  groceries.forEach((item) => {
    item.completed = true;
  });
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
