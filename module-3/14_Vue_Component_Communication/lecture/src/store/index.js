import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    name: 'Cigar Parties for Dummies',
    description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
    filter: 0,
    reviews: [
      {
        id: 1,
        reviewer: 'Malcolm Gladwell',
        title: 'What a book!',
        review:
          "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
        rating: 3,
        isFavorited: false
      },
      {
        id: 2,
        reviewer: 'Tim Ferriss',
        title: 'Had a cigar party started in less than 4 hours.',
        review:
          "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
        rating: 4,
        isFavorited: false
      },
      {
        id: 3,
        reviewer: 'Ramit Sethi',
        title: 'What every new entrepreneurs needs. A door stop.',
        review:
          "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
        rating: 1,
        isFavorited: false
      },
      {
        id: 4, 
        reviewer: 'Gary Vaynerchuk',
        title: 'And I thought I could write',
        review:
          "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
        rating: 3,
        isFavorited: false
      }
    ],
  },
  mutations: {
    ADD_REVIEW(state, review) {
      review.id = state.reviews.length + 1;
      state.reviews.unshift(review);
    },
    UPDATE_FILTER(state, filter) {
      state.filter = filter;
    },
    FLIP_FAVORITED(state, reviewToChange) {
      reviewToChange.isFavorited = !reviewToChange.isFavorited;
    }
  },
  actions: {
  },
  modules: {
  },
  strict: true // throws an error if the state is mutated outside of mutation handlers.
})
