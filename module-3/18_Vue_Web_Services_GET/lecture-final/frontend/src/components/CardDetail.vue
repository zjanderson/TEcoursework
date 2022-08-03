<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <div v-else>
      <h1>{{ card.title }}</h1>
      <p>{{ card.description }}</p>
      <comments-list :comments="card.comments"></comments-list>
    </div>
  </div>
</template>

<script>
import boardService from '@/services/BoardService.js';
import CommentsList from '@/components/CommentsList.vue';

export default {
  name: "card-detail",

  components: {
    CommentsList
  },

  created() {
    boardService.getCard(this.$route.params.cardID)
      .then(response => {
        this.card = response.data;
        this.isLoading = false;
      })
  },

  data() {
    return {
      isLoading: true,
      card: {}
    }
  }
};
</script>
