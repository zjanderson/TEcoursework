import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    activeTab: 'create',
    title: 'NLR May 2022 Java Yellow Capstone Selection',
    description: 'Please rank your capstone preferences. Each ranking selection must be unique.\nForms filled out incorrectly will result in your Instructor choosing for you! :)\n\nSelections are not guaranteed, but we will do our best to assign each student their #2 choice or better depending on demand.',
    questions: [
      {
        id: 1,
        required: true,
        type: 'Short answer',
        question: 'What is your name? (First Last)',
        answer: '',
        answerOptions: []
      },
      {
        id: 2,
        required: true,
        type: 'Multiple choice',
        question: 'What is your FIRST choice?',
        answer: '',
        answerOptions: [  
          {
            id: 1,
            value: 'Cookout Order Application'
          }, 
          {
            id: 2,
            value: 'Crop Planner'
          },
          {
            id: 3,
            value: 'Pet Play Pals'
          },
          {
            id: 4,
            value: 'Ranked Choice Voting App'
          },
          {
            id: 5,
            value: 'Restaurant Tinder'
          },
          {
            id: 6,
            value: 'Tech Fitness Pal'
          },
          {
            id: 7,
            value: 'TEgram'
          }
        ]
      }
    ],
    responses: [],
  },
  mutations: {
    SET_ACTIVE_TAB(state, activeTab) {
      state.activeTab = activeTab;
    },
    UPDATE_TITLE(state, title) {
      state.title = title;
    },
    UPDATE_DESCRIPTION(state, description) {
      state.description = description;
    },

    QUESTION_ADD(state) {
      const nextId = state.questions.map(q => q.id).reduce((prev, curr) => prev < curr ? curr : prev, 0) + 1;

      const newQuestion = { 
          id: nextId, 
          type: 'Short answer',
          answer: '',
          answerOptions: []
      }
      
      state.questions.push(newQuestion);
    },
    QUESTION_REMOVE_AT(state, index) {
      state.questions.splice(index, 1);
    },
    QUESTION_TOGGLE_REQUIRED(state, questionId) {
      const question = state.questions.find(q => q.id === questionId);
      question.required = !question.required;
    },
    QUESTION_UPDATE(state, obj) {
      const question = state.questions.find(q => q.id === obj.questionId);
      question.question = obj.value;
    },
    QUESTION_TYPE_UPDATE(state, obj) {
      const question = state.questions.find(q => q.id === obj.questionId);
      question.type = obj.value;
    },

    ANSWER_OPTION_CREATE(state, questionId) {
      const question = state.questions.find(q => q.id === questionId);

      const nextId = question.answerOptions.map(ao => ao.id).reduce((prev, curr) => prev < curr ? curr : prev, 0) + 1;
      const newAnswerOption = { 
        id: nextId,
        value: ''
      };

      question.answerOptions.push(newAnswerOption);
    },
    ANSWER_OPTION_UPDATE(state, obj) {
      const question = state.questions.find(q => q.id === obj.questionId);
      const answerOption = question.answerOptions.find(ao => ao.id === obj.answerOptionId);
      answerOption.value = obj.value;
    },
    ANSWER_OPTION_DELETE(state, obj) {
      const question = state.questions.find(q => q.id === obj.questionId);
      const answerOptionIndex = question.answerOptions.findIndex(ao => ao.id === obj.answerOptionId);

      question.answerOptions.splice(answerOptionIndex, 1);
    },

    RESPONSE_SET_ANSWER(state, obj) {
      const question = state.questions.find(q => q.id === obj.questionId);
      question.answer = obj.value;
    },
    RESPONSE_SUBMIT(state) {
      const newResponse = {
        answers: []
      };

      state.questions.forEach(q => {
        const currentAnswer = {
            questionId: q.id,
            answer: q.answer
        };

        newResponse.answers.push(currentAnswer);
      })

      state.responses.push(newResponse);

      state.questions.forEach(q => q.answer = ''); // reset answers
    },
  },
  actions: {
  },
  modules: {
  }
})
