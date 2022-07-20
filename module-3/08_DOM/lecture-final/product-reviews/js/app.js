const pageTitle = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Madwell',
    title: 'What a book!',
    review:
    "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const h2Element = document.getElementById('page-title');
  const pageTitleElement = h2Element.querySelector('.name');
  pageTitleElement.innerText = pageTitle;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  const descriptionElement = document.querySelector('.description');
  descriptionElement.innerText = description;
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 * 
 * <div class="review">
        <h4></h4>
        <div class="rating">
            <img src="img/star.png" class="ratingStar"/>
        </div>
        <h3></h3>
        <p></p>
    </div>
 * 
 */
function displayReviews() {
  const mainElement = document.getElementById('main');

  reviews.forEach((review) => {
    const reviewDiv = document.createElement('div');
    reviewDiv.classList.add('review'); // <div class="review"></div>

    addReviewer(reviewDiv, review.reviewer); // <div class="review"><h4>Malcolm Gladwell</h4></div>
    addRating(reviewDiv, review.rating);
    addTitle(reviewDiv, review.title);
    addReview(reviewDiv, review.review);

    mainElement.appendChild(reviewDiv);
  });
}

/**
 * I will create a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const h4 = document.createElement('h4'); // <h4></h4>
  h4.innerText = name;  // <h4>Malcolm Gladwell</h4>

  parent.appendChild(h4); // <div class="review"><h4>Malcolm Gladwell</h4></div>
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {

  const ratingDiv = document.createElement('div'); // <div></div>
  ratingDiv.classList.add('rating'); // <div class="rating"></div>

  for(let i = 1; i <= numberOfStars; i++) {
    const starImg = document.createElement('img'); // <img>
    starImg.setAttribute('src', 'img/star.png');   // <img src="img/star.png">

    ratingDiv.appendChild(starImg);
    /*
    <div class="rating">
      <img src="img/star.png">
      <img src="img/star.png">
      <img src="img/star.png">
      <img src="img/star.png">
      <img src="img/star.png">
    </div>
    */
  }  
  /* 
    <div class="review">
      <h4>Malcolm Gladwell</h4>
      <div class="rating">
        <img src="img/star.png">
        <img src="img/star.png">
        <img src="img/star.png">
        <img src="img/star.png">
        <img src="img/star.png">
      </div>
    </div>

  */
  parent.appendChild(ratingDiv);

}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const h3 = document.createElement('h3'); // <h3></h3>
  h3.innerText = title; // <h3>Some Review Title Here</h3>

  parent.appendChild(h3); 
  /* 
parent-> <div class="review">
           <h4>Malcolm Gladwell</h4>
           <h3>Some Review Title Here</h3>
         </div>
  */
}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const pElement = document.createElement('p'); // <p></p>
  pElement.innerText = review; // <p>blah blah blah</p>

  parent.appendChild(pElement);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
