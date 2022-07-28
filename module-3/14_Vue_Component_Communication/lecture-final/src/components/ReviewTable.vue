<template>
  <table>
    <thead>
      <tr>
        <th>Title</th>
        <th>Reviewer</th>
        <th>Review</th>
        <th>Rating</th>
        <th>Favorited</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="r in filteredReviews" v-bind:key="r.id">
        <td>{{ r.title }}</td>
        <td>{{ r.reviewer }}</td>
        <td>{{ r.review }}</td>
        <td class="stars">
          <img src="../assets/star.png" v-for="n in r.rating" v-bind:key="n" class="star" width="20px">
        </td>
        <td>
          <input type="checkbox" v-bind:checked="r.isFavorited" v-on:change="onFavoritedChange(r)">
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: "review-table",
  computed: {
    filteredReviews() {
      const reviewsFilter = this.$store.state.filter;
      const reviews = this.$store.state.reviews;
      return reviews.filter(review => {
        return reviewsFilter === 0 || reviewsFilter === review.rating;
      });
    }
  },
  methods: {
    onFavoritedChange(review) {
      this.$store.commit('FLIP_FAVORITED', review);
    }
  }
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
.stars {
  display: flex;
}
</style>
