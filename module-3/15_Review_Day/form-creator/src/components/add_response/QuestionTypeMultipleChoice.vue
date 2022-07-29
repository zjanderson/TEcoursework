<template>
    <div>
        <div v-for="answerOption in question.answerOptions" v-bind:key="getUniqueId(question.id, answerOption.id)">
            <input type="radio" :name="getUniqueName(question.id)" :id="getUniqueId(question.id, answerOption.id)" :value="answerOption.value" :checked="question.answer === answerOption.value" @change="setAnswer($event.target.value); $event.target.value = '';" :required="question.required">
            <label :for="getUniqueId(question.id, answerOption.id)">{{ answerOption.value }}</label>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        question: {
            type: Object,
            required: true
        }
    },

    methods: {
        getUniqueId(questionId, answerId) {
            return 'question' + questionId + 'answer' + answerId;
        },

        getUniqueName(questionId) {
            return 'question' + questionId;
        },

        setAnswer(value) {
            this.$store.commit('RESPONSE_SET_ANSWER', {
                questionId: this.question.id,
                value
            });
            this.$forceUpdate();
        }
    }
}
</script>