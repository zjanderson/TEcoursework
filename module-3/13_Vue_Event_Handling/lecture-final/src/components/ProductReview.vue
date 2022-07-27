<template>
  <main class="main">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount" v-on:click="filter = 0">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter = 1">{{ numberOfOneStarReviews }}</span>
        1 Star Review{{ numberOfOneStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter = 2">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter = 3">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter = 4">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well">
        <span class="amount" v-on:click="filter = 5">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? "" : "s" }}
      </div>
    </div>

    <a href="#" v-on:click.prevent="toggleShowForm">
      {{ showHideFormText }}
    </a>

    <form v-on:submit.prevent="addNewReview" v-show="showForm">
      <div class="form-element">
        <label for="reviewer">Name:</label>
        <input type="text" id="reviewer" v-model="newReview.reviewer">
      </div>
      <div class="form-element">
        <label for="title">Title:</label>
        <input type="text" id="title" v-model="newReview.title">
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review:</label>
        <textarea id="review" cols="30" rows="10" v-model="newReview.review"></textarea>
      </div>
      <input type="submit" value="Save">
      <input type="button" value="Cancel" v-on:click="resetForm">
    </form>

    <div
      class="review"
      v-bind:class="{ isFavorited: review.isFavorited }"
      v-for="review in filteredReviews"
      v-bind:key="review.id"
    >
      <input type="checkbox" class="float-right" v-bind:value="review.id" v-model="selectedReviewIDs">
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>
      <p>{{ review.review }}</p>
      <p>
        Favorite?
        <input type="checkbox" v-model="review.isFavorited" />
      </p>
    </div>


    <input type="text" v-on:keyup="logKey">
  </main>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties for Dummies",
      description:
        "Host and plan the perfect cigar party for all of your squirrelly friends.",
      filter: 0,
      newReview: {},
      reviews: [
        {
          id: 1,
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          isFavorited: false,
        },
        {
          id: 2,
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours.",
          review:
            "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
          isFavorited: false,
        },
        {
          id: 3,
          reviewer: "Ramit Sethi",
          title: "What every new entrepreneurs needs. A door stop.",
          review:
            "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
          rating: 1,
          isFavorited: false,
        },
        {
          id: 4,
          reviewer: "Gary Vaynerchuk",
          title: "And I thought I could write",
          review:
            "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 3,
          isFavorited: false,
        },
      ],
      selectedReviewIDs: [],
      showForm: false,
    };
  },
  computed: {
    averageRating() {
      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.reviews.length).toFixed(2);
    },
    filteredReviews() {
      return this.reviews.filter(review => this.filter === 0 || this.filter === review.rating);
    },
    numberOfOneStarReviews() {
       return this.numberOfReviews(1);
    },
    numberOfTwoStarReviews() {
       return this.numberOfReviews(2);
    },
    numberOfThreeStarReviews() {
       return this.numberOfReviews(3);
    },
    numberOfFourStarReviews() {
       return this.numberOfReviews(4);
    },
    numberOfFiveStarReviews() {
      return this.numberOfReviews(5);
    },
    showHideFormText() {
      if (this.showForm) {
        return 'Hide Form';
      }

      return 'Show Form';
    },
  },
  methods: {
    addNewReview(e) {
      e.preventDefault(); // another option to prevent default behavior besides using .prevent modifier

      this.newReview.id = this.reviews.length + 1;
      this.newReview.isFavorited = false;

      this.reviews.unshift(this.newReview);

      this.resetForm();
    },

    logKey(e) {
      console.log(e.key);
    },

    numberOfReviews(rating) {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === rating);
      }, 0);
    },

    resetForm() {
      this.newReview = {};
      this.toggleShowFormOff();
    },

    toggleShowFormOff() {
      this.showForm = false;
    },

    toggleShowForm() {
      this.showForm = !this.showForm;
    },
  
  }
};
</script>

<style scoped>
main.main {
  margin: 1rem 0;
}

main.main div.well-display {
  display: flex;
  justify-content: space-around;
}

main.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

main.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
  cursor: pointer;
}

main.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

main.main div.review.isFavorited {
  background-color: lightyellow;
}

main.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

main.main div.review div.rating img {
  height: 100%;
}

main.main div.review p {
  margin: 20px;
}

main.main div.review h3 {
  display: inline-block;
}

main.main div.review h4 {
  font-size: 1rem;
}

div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input,
div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type="button"] {
  width: 100px;
}
form > input[type="submit"] {
  width: 100px;
  margin-right: 10px;
}

.float-right {
  float: right;
}
</style>

