<template>
    <main>
        <section class="section heading">
            <h1>{{ $store.state.title }}</h1>
            <p class="description">{{ $store.state.description }}</p>
        </section>

      <form @submit.prevent="saveForm">
        <section class="section" v-for="q in $store.state.questions" v-bind:key="q.id">
          <h2>
            {{ q.question }} <span v-show="q.required" class="required"> *</span>
          </h2>

          <question-type-short-answer :question="q" v-if="q.type === 'Short answer'"></question-type-short-answer>
          <question-type-multiple-choice :question="q" v-else-if="q.type === 'Multiple choice'"></question-type-multiple-choice>
        </section>

        <div style="float: left">
          <input type="submit" value="Submit" class="button">
        </div>
      </form>
    </main>
</template>

<script>
import QuestionTypeShortAnswer from './QuestionTypeShortAnswer.vue';
import QuestionTypeMultipleChoice from './QuestionTypeMultipleChoice.vue';

export default {
    components: {
        QuestionTypeShortAnswer,
        QuestionTypeMultipleChoice
    },

    methods: {
        saveForm() {
            this.$store.commit('RESPONSE_SUBMIT');
        }
    }
}
</script>

<style scoped>
.description {
    white-space: pre-wrap;
}
</style>