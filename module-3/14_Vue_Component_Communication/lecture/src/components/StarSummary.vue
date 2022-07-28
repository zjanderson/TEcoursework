<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter">{{ numberOfReviews }}</span>
    {{ rating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  props: ["rating"],
  methods: {
    updateFilter() {
    }
  },
  computed: {
    numberOfReviews() {
      const reviews = [];
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

