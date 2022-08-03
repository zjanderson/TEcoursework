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
        console.log('this runs first');

        shoppingListService
            .getShoppingList()
            .then(response => {
                console.log('this runs third');
                this.shoppingList = response.data;
            })
            .catch(error => {
                console.log('this runs third');
                console.log(error.response);
            })

        console.log('this runs second');
    },

    data() {
        return {
            shoppingList: {}
        }
    }
}
</script>
