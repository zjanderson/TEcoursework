<template>
  <main class="main">
      <h2>Product Reviews for {{ name }}</h2>
      <p class="description">{{ description }}</p>

        <div class="well-display">
            <div class="well">
                <span class="amount">{{ averageRating }}</span>
                Average Rating
            </div>
            <div class="well">
                <span class="amount">{{ numberOfOneStarReviews }}</span>
                1 Star Review
            </div>
            <div class="well">
                <span class="amount">{{ numberOfTwoStarReviews }}</span>
                2 Star Review
            </div>
            <div class="well">
                <span class="amount">{{ numberOfThreeStarReviews }}</span>
                3 Star Review
            </div>
            <div class="well">
                <span class="amount">{{ numberOfFourStarReviews }}</span>
                4 Star Review
            </div>
            <div class="well">
                <span class="amount">{{ numberOfFiveStarReviews }}</span>
                5 Star Review
            </div>
        </div>

      <div class="review" v-for="review in reviews" v-bind:key="review.id" v-bind:class="{ favorited: review.isFavorited }">
          <h4>{{ review.reviewer }}</h4>
          <div class="rating">
              <img src="../assets/star.png" alt="star image" v-for="n in review.rating" v-bind:key="n">
          </div>
          <h3>{{ review.title }}</h3>
          <p>{{ review.review }}</p>
          <input type="checkbox" v-model="review.isFavorited">Favorited?
      </div>
  </main>
</template>

<script>
export default {

    data() {
        return {
            name: 'Cigar Parties for Dummies',
            description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
            reviews: [
                {
                    id: 1,
                    title: 'What a book!',
                    reviewer: 'Malcolm Gladwell',
                    rating: 3,
                    review: 'It certainly is a book. I mean, I can see that. Pages kept together with glue, and then writing on it, in some language.',
                    isFavorited: true
                },
                {
                    id: 2,
                    title: 'Awesome Book!',
                    reviewer: 'Malcolm Gladwell',
                    rating: 5,
                    review: 'Blah blah blah.',
                    isFavorited: false
                }
            ]
        }
    },

    computed: {
        averageRating() {
            const sumOfRatings = this.reviews.reduce((sum, review) => {
                return sum + review.rating;
            }, 0);

            return (sumOfRatings / this.reviews.length).toFixed(2);
        },

        numberOfOneStarReviews() {
            return this.reviews.reduce((currentCount, review) => {
                if (review.rating === 1) {
                    currentCount++;
                }

                return currentCount;
            }, 0);
        },

        numberOfTwoStarReviews() {
            return this.reviews.reduce((currentCount, review) => {
                if (review.rating === 2) {
                    currentCount++;
                }

                return currentCount;
            }, 0);
        },

        numberOfThreeStarReviews() {
            return this.reviews.reduce((currentCount, review) => {
                if (review.rating === 3) {
                    currentCount++;
                }

                return currentCount;
            }, 0);
        },

        numberOfFourStarReviews() {
            return this.reviews.reduce((currentCount, review) => {
                if (review.rating === 4) {
                    currentCount++;
                }

                return currentCount;
            }, 0);
        },

        numberOfFiveStarReviews() {
            return this.reviews.reduce((currentCount, review) => {
                if (review.rating === 5) {
                    currentCount++;
                }

                return currentCount;
            }, 0);
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
}

main.main div.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
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

main.main div.review.favorited {
    background-color: lightyellow;
}

</style>