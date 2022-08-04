<template>
  <div>
    <h1>Add New Card</h1>
    <card-form :boardID="Number.parseInt($route.params.boardID)"></card-form>
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
