<template>
  <div class="main">
      <h1>{{ product.name }}</h1>
      <p class="description">{{ product.description }}</p>

      <div class="actions">
          <router-link :to="{ name: 'products' }">Back to Products</router-link>
            |
          <router-link :to="{ name: 'add-review', params: { id: product.id }, query: { blah: 'hello' } }">
              Add New Review
          </router-link>
      </div>

      <div class="well-display">
          <average-summary></average-summary>
          <star-summary :rating="1"></star-summary>
          <star-summary :rating="2"></star-summary>
          <star-summary :rating="3"></star-summary>
          <star-summary :rating="4"></star-summary>
          <star-summary :rating="5"></star-summary>
      </div>

      <review-list></review-list>
  </div>
</template>

<script>
import AverageSummary from '../components/AverageSummary.vue';
import ReviewList from '../components/ReviewList.vue';
import StarSummary from '../components/StarSummary.vue';

export default {
    components: {
        AverageSummary,
        ReviewList,
        StarSummary
    },

    computed: {
        product() {
            return this.$store.state.products.find(p => p.id === this.$store.state.activeProduct);
        }
    },

    created() {
        const productId = Number.parseInt(this.$route.params.id);

        this.$store.commit('SET_ACTIVE_PRODUCT', productId);
    }
}
</script>
