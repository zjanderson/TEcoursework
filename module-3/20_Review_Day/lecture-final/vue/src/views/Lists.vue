<template>
  <div>
      <div v-for="list in $store.state.shoppingLists" v-bind:key="list.listId">

          {{ list.name }}

      </div>
  </div>
</template>

<script>
import shoppingListService from '@/services/ShoppingListService.js';

export default {
    created() {
        shoppingListService
            .getAllForUser()
            .then(response => {
                this.$store.commit('SET_SHOPPING_LISTS', response.data);
            })
    }
}
</script>

<style>

</style>