import axios from 'axios';

export default {

  getBoards() {
    return axios.get('/boards');
  },

  getCards(boardId) {
    return axios.get('/boards/' + boardId);
  },

  getCard(cardID) {
    return axios.get(`/cards/${cardID}`);
  }

}
