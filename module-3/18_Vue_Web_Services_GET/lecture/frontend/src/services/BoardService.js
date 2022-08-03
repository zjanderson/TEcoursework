import axios from 'axios';

export default {

  getBoards() {
    return axios.get('/boards');
  },

  getCards(boardID) {
    return axios.get('/boards/' + boardID);
  },

  getCard(cardID) {
    return axios.get(`/cards/${cardID}`);
    }

  }