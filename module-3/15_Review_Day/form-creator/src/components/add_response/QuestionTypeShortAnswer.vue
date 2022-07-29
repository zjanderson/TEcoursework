<template>
    <input type="text" placeholder="Short answer text" :value="question.answer" @change="setAnswer($event.target.value)" :required="question.required">
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
        setAnswer(value) {
            this.$store.commit('RESPONSE_SET_ANSWER', {
                questionId: this.question.id,
                value
            })
        }
    }
}
</script>