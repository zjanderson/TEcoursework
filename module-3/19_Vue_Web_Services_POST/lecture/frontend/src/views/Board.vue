<template>
  <cards-list :boardId="boardId" />
</template>

<script>
import CardsList from '@/components/CardsList';

export default {
  components: {
    CardsList
  },
  data() {
    return {
      boardId: 0
    };
  },
  created() {
    this.boardId = Number.parseInt(this.$route.params.id);
    this.$store.commit("SET_ACTIVE_BOARD", this.boardId);
  }
};
</script>
