import axios from 'axios';

export default {

  getBoards() {
    return axios.get('/boards');
  },

  getCards() {
    throw Error('Not yet implemented');
  },

  getCard(boardID, cardID) {
    return axios.get(`/boards/${boardID}`).then((response) => {
      const cards = response.data.cards;
      return cards.find(card => card.id == cardID);
    });
  }

}
