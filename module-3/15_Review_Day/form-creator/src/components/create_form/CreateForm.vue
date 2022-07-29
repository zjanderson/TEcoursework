<template>
    <main>
      <section class="section heading">
        <input type="text" class="title" v-model="title">
        <textarea class="description" v-model="description"></textarea>
      </section>

        <a href="#" @click.prevent="addQuestion">
          <i class="fa fa-plus-circle"></i> Add New Question
        </a>

      <div v-for="(q, questionIndex) in $store.state.questions" v-bind:key="q.id" class="question-group">
        <section class="section">
          
          <header class="question-header">
            <input type="text" :value="q.question" @change="updateQuestion(q.id, $event.target.value)" placeholder="Ask question here" class="question">
            <select :value="q.type" @change="updateQuestionType(q.id, $event.target.value)">
              <option value="Short answer">Short answer</option>
              <option value="Multiple choice">Multiple choice</option>
            </select>
          </header>
          
          <!-- question type multiple choice -->
          <question-type-multiple-choice :question="q" v-if="q.type === 'Multiple choice'"></question-type-multiple-choice>

          <!-- question type short answer -->
          <question-type-short-answer :question="q" v-else-if="q.type === 'Short answer'"></question-type-short-answer>

          <footer>
            <div>
              <a href="#" @click.prevent="">
                  <i title="Duplicate" class="fa fa-clone"></i>
              </a>
              <a href="#" @click.prevent="removeQuestion(questionIndex)">
                  <i title="Delete" class="fa fa-trash-o"></i>
              </a>
            </div>
            <div>
                <label :for="getRequiredId(q.id)">Required</label>
                <input :id="getRequiredId(q.id)" type="checkbox" :checked="q.required" @change="toggleRequired(q.id)">
            </div>
          </footer>
        </section>
      </div>
    </main>
</template>

<script>
import QuestionTypeMultipleChoice from './QuestionTypeMultipleChoice.vue';
import QuestionTypeShortAnswer from './QuestionTypeShortAnswer.vue';

export default {
    components: {
        QuestionTypeMultipleChoice,
        QuestionTypeShortAnswer
    },

    computed: {
        title: {
            get () {
                return this.$store.state.title;
            },
            set (value) {
                this.$store.commit('UPDATE_TITLE', value);
            }
        },

        description: {
            get () {
                return this.$store.state.description;
            },
            set (value) {
                this.$store.commit('UPDATE_DESCRIPTION', value);
            }
        }
    },

    methods: {
        addQuestion() {
            this.$store.commit('QUESTION_ADD');
        },

        getRequiredId(questionId) {
            return 'question-' + questionId + '-is-required';
        },

        removeQuestion(index) {
            this.$store.commit('QUESTION_REMOVE_AT', index);
        },

        toggleRequired(questionId) {
          this.$store.commit('QUESTION_TOGGLE_REQUIRED', questionId);
        },

        updateQuestion(questionId, value) {
          this.$store.commit('QUESTION_UPDATE', { questionId, value })
        },

        updateQuestionType(questionId, value) {
          this.$store.commit('QUESTION_TYPE_UPDATE', { questionId, value })
        }
    }
}
</script>

<style scoped>
.section.heading {
    display: flex;
    flex-direction: column;
    margin-bottom: 40px;
}

.section.heading .title,
.section.heading .description {
    border: none; 
    border-bottom: 1px solid lightgray;
    padding: 5px; 
}

.section.heading .title {
    font-size: 1.25rem;
}

.section.heading .description {
    min-height: 160px; 
    flex-grow:1; 
    margin-top: 20px; 
}

.section {
  border-radius: 5px;
  background-color: white;
  color: black;
  border: 1px solid lightgray;
  margin-bottom: 20px;
  padding: 20px;
  font-size: .8rem;
  text-align: left;;
}

.question-group {
    margin-top: 10px;
}

.question-header {
    display: flex; 
    justify-content: space-between;
}

.question-header .question {
    flex-grow:1; 
    margin-right: 10px;
}

select {
  padding: 5px;
}

label {
  cursor: pointer;
}

input, textarea {
  border: none;
  border-bottom: 1px solid lightgray;
  padding: 5px;
}

input:focus, textarea:focus {
  outline: none;
  border-bottom: 1px solid black !important;
}

ul {
  list-style-type: none;
}
li:last-child {
  cursor: pointer;
}

a, a:visited, a:hover {
  color: rgb(75, 73, 73);
  text-decoration: none;
}

footer {
    display:flex; 
    justify-content: flex-end; 
    margin-top: 30px; 
    padding-top: 10px;
    border-top: 1px solid lightgray; 
}

footer > div:first-child {
    border-right: 1px solid lightgray; 
    line-height: 1.5rem;
}

footer > div:last-child {
    line-height: 1.5rem; 
    color: gray; 
    padding-left: 10px;
}

footer > div > a {
    padding: 10px;
}

i {
    color: gray;
    font-size: 1.5rem;
}

</style>