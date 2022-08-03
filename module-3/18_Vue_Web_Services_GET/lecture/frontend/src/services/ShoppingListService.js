import axios from "axios";

export default {
  getShoppingList() {
    return axios.get('/shopping-list')
  }
}