<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter">{{ numberOfReviews }}</span>
    {{ rating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  //props: ["rating", "prop2"],
  props: {
    rating: {
      type: Number,
      required: true
    }
  },
  methods: {
    updateFilter() {
      this.$store.commit('UPDATE_FILTER', parseInt(this.rating));
    }
  },
  computed: {
    numberOfReviews() {
      const reviews = this.$store.state.reviews;
      return reviews.reduce((currentCount, review) => {
        if(review.rating === parseInt(this.rating)) {
          currentCount++;
        }
        return currentCount;
      }, 0);
    }
  }
};
</script>

