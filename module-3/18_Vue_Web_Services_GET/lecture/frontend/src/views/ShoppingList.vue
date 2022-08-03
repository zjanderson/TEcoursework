<template>
  <ul>
    <li v-for="item in shoppingList.items" :key="item">
      {{ item }}
    </li>
  </ul>
</template>

<script>

import shoppingListService from '@/services/ShoppingListService.js'

export default {

  created() {
    shoppingListService.getShoppingList().then(response => {
      this.shoppingList = response.data;
    })
    .catch(error => {
      console.log(error.response);
    })
  },

  data() {
    return {
      shoppingList: {}
    }
  }

}
</script>