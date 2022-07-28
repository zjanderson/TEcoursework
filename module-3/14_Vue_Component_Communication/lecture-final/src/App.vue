<template>
  <div id="app" class="main">
    <h1>Product Reviews for {{ $store.state.name }}</h1>
    <p class="description">{{ $store.state.description }}</p>
    <div class="well-display">
      <average-summary></average-summary>
      <star-summary :rating="1"></star-summary>
      <star-summary :rating="2"></star-summary>
      <star-summary :rating="3"></star-summary>
      <star-summary :rating="4"></star-summary>
      <star-summary :rating="5"></star-summary>
    </div>
    <add-review></add-review>

    <a href="#" v-on:click.prevent="toggleDisplay">{{ toggleDisplayText }}</a>
    <review-list v-if="display === 'list'"></review-list>
    <review-table v-else></review-table>
  </div>
</template>

<script>
import AverageSummary from "./components/AverageSummary.vue";
import StarSummary from "./components/StarSummary.vue";
import AddReview from "./components/AddReview.vue";
import ReviewList from "./components/ReviewList.vue";
import ReviewTable from "./components/ReviewTable.vue";

export default {
  name: "app",
  components: {
    AverageSummary,
    StarSummary,
    AddReview,
    ReviewList,
    ReviewTable
  },

  data() {
    return {
      display: 'list'
    }
  },

  computed: {
    toggleDisplayText() {
      if (this.display === 'list') {
        return 'Display Table View';
      }

      return 'Display List View';
    }
  },

  methods: {
    toggleDisplay() {
      if (this.display === 'list') {
        this.display = 'table';
      } else {
        this.display = 'list';
      }
    }
  }

};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
div.main {
  margin: 1rem 0;
}
div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.well-display div.well {
  cursor: pointer;
}
</style>
