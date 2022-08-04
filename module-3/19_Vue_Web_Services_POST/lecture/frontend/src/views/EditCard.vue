<template>
  <div>
    <h1>Edit Card</h1>
    <card-form 
      :boardID="Number.parseInt($route.params.boardID)" 
      :cardID="Number.parseInt($route.params.cardID)">
    </card-form>
  </div>
</template>

<script>
import CardForm from "@/components/CardForm";

export default {
  components: {
    CardForm
  }
};
</script>
