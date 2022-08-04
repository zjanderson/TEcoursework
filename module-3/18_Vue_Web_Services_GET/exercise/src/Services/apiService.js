import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  listTopics() {
    return http.get('/topics');
  },

  getDetails(id) {
    return http.get(`topics/${id}`);
  }
  // list() {
  //   return http.get('/users');
  // },

  // get(id) {
  //   return http.get(`/users/${id}`);
  // }

}