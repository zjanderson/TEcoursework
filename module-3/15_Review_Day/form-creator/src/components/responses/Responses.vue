<template>
    <main>
        <section class="section" v-for="q in $store.state.questions" v-bind:key="q.id">
            <h2>{{ q.question }}</h2>
            <div class="response-count">
                {{ getResponsesForQuestionId(q.id).length }} response{{ getResponsesForQuestionId(q.id).length !== 1 ? 's' : ''}}
            </div> 
            
            <div v-for="(r, index) in getResponsesForQuestionId(q.id)" v-bind:key="index">
                <div  class="answer" v-if="r.answer !== ''">
                    
                    {{ r.answer }}
                </div>
            </div>
        </section>
    </main>
</template>

<script>
export default {
    methods: {
        getResponsesForQuestionId(id) {
            const thisQuestionsResponses = [];

            this.$store.state.responses.forEach(r => {

                r.answers.forEach(ra => {
                    if (ra.questionId === id && ra.answer !== '') {
                        thisQuestionsResponses.push(ra);
                    }
                });

            });

            return thisQuestionsResponses;
        }
    }
}
</script>

<style scoped>
h2 {
    margin: 0;
}

.response-count {
    font-size:.8rem; 
    margin-top:5px;
}

.answer {
    margin-top:15px; 
    padding:5px; 
    background-color: #eee;
}
</style>