<template>
    <ul v-if="question.type === 'Multiple choice'">
        <li v-for="answerOption in question.answerOptions" v-bind:key="answerOption.id">
            <input type="text" :value="answerOption.value" @change="updateAnswerOption(question.id, answerOption.id, $event.target.value)">
            
            <a href="#" @click.prevent="removeAnswerOption(question.id, answerOption.id)">
                <i class="fa fa-times" title="Remove" style="color: lightgray; margin-left: 30px;"></i>
            </a>
        </li>

        <li @click="addAnswerOption(question.id)">+ Add Option</li>
    </ul>
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
        addAnswerOption(questionId) {
            this.$store.commit('ANSWER_OPTION_CREATE', questionId);
        },

        updateAnswerOption(questionId, answerOptionId, value) {
            this.$store.commit('ANSWER_OPTION_UPDATE', {
                questionId,
                answerOptionId,
                value
            })
        },

        removeAnswerOption(questionId, answerOptionId) {
            this.$store.commit('ANSWER_OPTION_DELETE', { questionId, answerOptionId });
        }
    }
}
</script>

<style scoped>
ul {
    text-align:left; 
    padding:0; 
    margin:0; 
    margin-top: 20px;
}

li {
    padding-top:5px; 
    padding-bottom:5px; 

    display:flex; 
    align-items: center;
}

li > input {
    flex-grow: 1;
}

li:last-child {
    display: initial;
    margin-top: 10px; 
    color: gray;
}
</style>