<template>
  <card-detail 
    :boardID="Number.parseInt($route.params.boardID)" 
    :cardID="Number.parseInt($route.params.cardID)">
  </card-detail>
</template>

<script>
import CardDetail from '@/components/CardDetail';

export default {
  components: {
    CardDetail
  }
};
</script>
