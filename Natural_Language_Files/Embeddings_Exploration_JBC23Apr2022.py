#!/usr/bin/env python
# coding: utf-8

# # COURSE: Natural Language Processing 
# ##### SEMESTER: Spring 2 2022
# ##### NAME: Joe Cruz
# ##### DATE: 21Apr2022

# # Programming Assignment: Embeddings Exploration 

# ## Part 1 - GloVE embeddings
# 
# Download the Wikipedia 2014 + Gigaword 5 embedding from https://github.com/stanfordnlp/GloVe.  Note: The download is blocked by Chrome.  I was able to download it using Firefox or Safari.  You can use the code below to create a Word2Vec model from the GloVE files.

# In[1]:


#Generates the Word2Vec model using the GloVE file.
from gensim.test.utils import datapath, get_tmpfile
from gensim.models import KeyedVectors
from gensim.scripts.glove2word2vec import glove2word2vec

glove_file = datapath('C:/Users/Joe Cruz/Natural_Language_Processing_Spring2/Week6/glove.6B.300d.txt') 
model = KeyedVectors.load_word2vec_format(glove_file, binary=False, no_header=True)


# ### Polysemous Words
# Find a [polysemous](https://en.wikipedia.org/wiki/Polysemy) word (for example, "leaves" or "scoop") such that the top-10 most similar words (according to cosine similarity) contains related words from both meanings. For example, "leaves" has both "vanishes" and "stalks" in the top 10, and "scoop" has both "handed_waffle_cone" and "lowdown". You will probably need to try several polysemous words before you find one. Please state the polysemous word you discover and the multiple meanings that occur in the top 10. Why do you think many of the polysemous words you tried didn't work?
# 
# Note: You should use `model.most_similar(word)` function to get the top 10 similar words. This function ranks all other words in the vocabulary with respect to their cosine similarity to the given word. For further assistance please check the [GenSim documentation](https://radimrehurek.com/gensim/models/keyedvectors.html#gensim.models.keyedvectors.FastTextKeyedVectors.most_similar).

# #### Polysemous word - "Live" 

# In[2]:


#Returns a list of the most similar words to the word 'live' based upon the cosine similarity scores.
model.most_similar("live")


# In[3]:


#TEST: WORDS THAT DID NOT WORK and did not have similar words from both meanings
#model.most_similar("book")
#model.most_similar("bank")
#model.most_similar("chips")
#model.most_similar("right")
#model.most_similar("coach")


#TEST:OTHER TEST WORD THAT WORKED and had similar words with both meanings
#model.most_similar("arms")


# #### The polysemous word that I found was 'lives'.  The top ten similar words (using cosine similarity) can be seen just above. The similar words to 'lives' displayed multiple meanings such as the state of living in a given area (or making residence in a specific location) denoted by the words 'living', 'where', and 'lived'. Another meaning was related to the state of living/existing in life denoted by the word 'lives' (i.e. he lives). Another meaning correlated to some kind of event occuring in front of an audience of people, which was denoted with the words 'concert', 'broadcast', 'people', 'show', and 'shows'.
# 
# #### Of all the words that I had tried, I was only able to find two of the seven that I attempted to use. I think that the reason that many of these did not work is due to their associations and how often they are associated with different definitions within the embeddings/text. For instance, one word that I tested was 'book'. 'Book' can be both a noun and a verb, where the book refers to a piece of reading material created by an author while 'to book' refers to reserving or making an official record of an offender. Instead of obtaining any words correlated to the verb, only words related to authored materials (i.e. published, novel, biography) would be returned in the top ten most similar words. Thus, with less associations/uses of the other definitions, it is less likely for some polysemous words to display these defintions within the most similar words lists. This is especially true given this is a word2vec model that does not utilize the global co-occurences. If these definitions are not found within the windows created, then it will not be seen and the likliehood that the top words related to the other definitions appear would be low.  # 

# ###  

# ### Synonyms & Antonyms 
# When considering Cosine Similarity, it's often more convenient to think of Cosine Distance, which is simply 1 - Cosine Similarity.
# 
# Find three words (w1,w2,w3) where w1 and w2 are synonyms and w1 and w3 are antonyms, but Cosine Distance(w1,w3) < Cosine Distance(w1,w2). For example, w1="happy" is closer to w3="sad" than to w2="cheerful".
# 
# Once you have found your example, please give a possible explanation for why this counter-intuitive result may have happened.
# 
# You should use the `distance(w1, w2)` function here in order to compute the cosine distance between two words. 

# In[4]:


# Creates the three words that will be compared, where w1 and w2 are synonyms and w1 and w3 are antonyms. 
w1 = "quiet"
w2 = "mild"
w3 = "loud"

# Obtains the cosine similarity distance between words 1 and 2
w1_w2_dist = model.distance(w1, w2)

# Obtains the cosine similarity distance between words 1 and 3
w1_w3_dist = model.distance(w1, w3)

#Prints the cosine similarity distances as well as their associated words to screen.
print(f"Synonyms {w1}, {w2} have cosine distance: {w1_w2_dist}")
print(f"Antonyms {w1}, {w3} have cosine distance: {w1_w3_dist}")


# #### The words chosen for this exercise were as follows: word 1 was 'quiet', word 2 was 'mild', and word 3 was 'loud'. The cosine distances between word 1 and word 2 and word 1 and word 3 are shown just above. It is shown that the cosine distance between 'quiet' and 'mild' was ~0.694 while the cosine distance between 'quiet' and 'loud' was ~0.649 (Cosine Distance(w1, w3) < Cosine Distance (w1,w2)). Often times, one would think that the antonyms should have the larger cosine distance between two words while the synonyms would have less distance. One potential explanation for this phenomenon could be related back to polysemous words. Since the word quiet has similar meanings, it can have different synonyms based upon the meaning that is being implied. For instance, quiet can mean 'without or with little sound' or it can mean 'calm and peaceful'. Pending upon the meaning used, there are different synonyms such as 'muted' or 'silent' for the sound definition or 'secluded' or 'shy' or 'mild'  for the calm/peaceful definition. Consequentially, since there are different synonyms associated with the different definitions, there is a chance that the word embeddings do not reflect the instances in which a certain definition is used. So for this example, it is possible that the instances of the word 'mild' was not considered close to the word 'quiet' since few embeddings included words regarding this definition. 

# #### 

# ### Solving Analogies with Word Vectors
# Word2Vec vectors have been shown to sometimes exhibit the ability to solve analogies.
# 
# As an example, for the analogy "man : king :: woman : x", what is x?
# 
# The `most_similar` function finds words that are most similar to the words in the positive list and most dissimilar from the words in the negative list. The answer to the analogy will be the word ranked most similar (largest numerical value).

# In[5]:


import pprint
pprint.pprint(model.most_similar(positive=["woman", "king"], negative=["man"]))


# ### Finding Analogies 
# Find an example of analogy that holds according to these vectors (i.e. the intended word is ranked top). In your solution please state the full analogy in the form x:y :: a:b. If you believe the analogy is complicated, explain why the analogy holds in one or two sentences.
# 
# Note: You may have to try many analogies to find one that works!

# In[6]:


#This finds the top most similar words to the positive list ('down' and 'right') and the most dissimilar from the words
#in the negative list ('left'). The highest ranked word (highest value) is the most similar and thus is the word that most 
#likely will fit the analogy. 

import pprint
pprint.pprint(model.most_similar(positive=["down", "right"], negative=["left"]))
# left:right :: down:up


# ### The analogy that was found to work was 'left' is to 'right' as 'down' is to 'up'. 
# 
# ### left:right :: down:up
# 
# ### The top numerical value of the list of 10 most similar words was the term 'up', thus this analogy worked. This analogy holds because it is comparing two horizontal directions together that are opposites followed by two vertical directions that are also opposites. 

# ### 

# ### Incorrect Analogy 
# Find an example of analogy that does not hold according to these vectors. In your solution, state the intended analogy in the form x:y :: a:b, and state the (incorrect) value of b according to the word vectors.

# In[7]:


#This finds the top most similar words to the positive list ('carrot' and 'flower') and the most dissimilar from the
#words in the negative list ('rose'). The highest ranked word (highest value) is the most similar and thus is the word that
#most likely will fit the analogy. 

pprint.pprint(model.most_similar(positive=["carrot", "flower"], negative=["rose"]))
#Attempted Analogy:
# rose:flower :: carrot:vegetable 


# ### The analogy that was intended for use was 'rose' is to 'flower' as 'carrot' is to 'vegetable'. 
# 
# ### rose:flower :: carrot:vegetable 
# 
# ### This analogy holds because a rose is a type of flower and a carrot is a type of vegetable. 
# 
# 
# ### According to the most similar list returned the highest value returned was 'celery', which would mean the returned analogy would be 'rose' is to 'flower' as 'carrot' is to 'celery'. It can be seen that the term 'vegetable' is not even in the list of the top ten words, but different types of vegetables are in the list. 

# ####  

# ### Analysis of Bias in Word Vectors
# It's important to be cognizant of the biases (gender, race, sexual orientation etc.) implicit to our word embeddings.
# 
# For example, run the code below, to examine (a) which terms are most similar to "woman" and "boss" and most dissimilar to "man", and (b) which terms are most similar to "man" and "boss" and most dissimilar to "woman". 

# In[8]:


pprint.pprint(model.most_similar(positive=["woman", "boss"], negative=["man"]))
# man: boss :: woman: ?
print()
pprint.pprint(model.most_similar(positive=["man", "boss"], negative=["woman"]))
# woman: boss:: man: ?


# ###  A. The following is the list of words that are most similar to the term 'woman' and 'boss' and most dissimilar to 'man' in order of most similar to least: 'bosses', 'girlfriend', 'her', 'mother', 'wife', 'daughter', 'husband', 'boyfriend', 'manager', and 'girl. It is clear that words that are similar to 'woman' and 'boss' are often related to less work-related terms. This is supported by the fact that the second most similar word refers to 'girlfriend' rather than 'manager'.  
# 
# 
# ### B.  The words that are most similar to 'man' and 'boss' and most dissimilar to 'woman' in order of most similar to least: 'bosses', 'manager', 'ferguson', 'guy', 'brother', 'mr.', 'mafia', 'tottenham', 'gambino', 'mourinho'. It is clear that the words similar to 'man', and 'boss' is heavily related to more words associated with work such as a 'manager', which was the second most similar word to 'man' and 'boss'. This is clearly a biased set, as can be seen by the fact that the second most similar word to 'man' and 'boss' was not 'boyfriend', as it was 'girlfriend' for the 'woman' and 'boss' example.  

# #### 

# ### Independent Analysis of Bias in Word Vectors 
# Use the `most_similar` function to find another case where some bias is exhibited by the vectors. Please briefly explain the example of bias that you discover.

# In[9]:


pprint.pprint(model.most_similar(positive=["overweight", "person"], negative=["skinny"]))
# overweight:person :: skinny: ?
print()
pprint.pprint(model.most_similar(positive=["skinny", "person"], negative=["overweight"]))
# skinny: person :: overweight: ?


# ### The example of bias that I investigated was the stigma between overweight individuals and skinny individuals. 
# 
# ### In the first set of top similar words, I obtained the most similar words to the terms 'overweight' and 'person' as well as the most dissimilar to the term 'skinny'. In this set of similar words, the terms of interest are 'obese', 'patient', and 'risk'. The term 'obese' was the second most similar term, which, in my opinion, points towards a bias that overweight individuals are automatically obese. This is not the case though, as there are many individuals that are not clinically diagnosed as obese that are overweight due to larger quantities of muscle mass. Furthermore, the inclusion of these other terms such as 'patient' and 'risk' imply that overweight individuals (that are not obese) are automatically designated as a risk and are frequently associated as hospital patients. 
# 
# ### In the second set of top similar words, I obtained the most similar words to the terms 'skinny' and 'person', as well as the most dissimilar to the term 'overweight'. In this set of similar words, the terms of interest are 'guy', 'kind', 'woman', and 'nice'. To begin with, the terms 'guy' and 'woman' are more similar to the term 'skinny' than to the word 'overweight', which I thought was kind of strange considering we are still including the term 'person'. This makes me wonder if there is some sort of bias that overweight individuals are not necessarily seen as people. Furthermore, the terms 'kind' and 'nice' were also surprising to see as the most similar to 'skinny' and not to 'overweight'. This seems to propogate a kind of bias that overweight individuals are not kind or nice generally. 
# 
# ### Overall, there seemed to be some bias associated with overweight individuals especially in comparison to skinny individuals according to these embeddings. Specifically, the bias's were that overweight individuals are obese, likely to be associated as a hospital patient with high risk, not generally nice or kind. These bias's are completely based upon the embeddings and are the resulting of comparing the most similar words associated with 'overweight' and 'person' that are least similar to 'skinny' with the most similar words associated with 'skinny' and 'person' that are least similar to 'overweight'. 
# 

# ####  

# ## Create your own embeddings
# 
# Using the Gensim library, create embeddings from **five** of the texts in the Gutenberg corpus.  The code below shows how you can do that.  

# In[10]:


import nltk
from nltk.corpus import gutenberg
from string import punctuation
import gensim

# Obtains the sentences in the blake-poems.txt file and puts all words in lower case and attempts to remove punctuation
# Then the Word2Vec model is created for the blake-poems text. 
blake_poems_sents = gutenberg.sents("blake-poems.txt")
simplified_sentences_blake = [[word.lower() for word in sent if word not in punctuation] for sent in blake_poems_sents]
blake_model = gensim.models.Word2Vec(simplified_sentences_blake)

# Obtains the sentences in the melville-moby_dick.txt file and puts all words in lower case and attempts to remove 
# punctuation. Then the Word2Vec model is created for the moby_dick text. 
moby_dick_sents = gutenberg.sents("melville-moby_dick.txt")
simplified_sentences_moby = [[word.lower() for word in sent if word not in punctuation] for sent in moby_dick_sents]
moby_model = gensim.models.Word2Vec(simplified_sentences_moby)

# Obtains the sentences in the milton-paradise.txt file and puts all words in lower case and attempts to remove punctuation
# Then the Word2Vec model is created for the paradise text. 
milton_sents = gutenberg.sents("milton-paradise.txt")
simplified_sentences_milton = [[word.lower() for word in sent if word not in punctuation] for sent in milton_sents]
milton_model = gensim.models.Word2Vec(simplified_sentences_milton)

# Obtains the sentences in the bryant-stories.txt file and puts all words in lower case and attempts to remove punctuation
# Then the Word2Vec model is created for the bryant stories text. 
bryant_sents = gutenberg.sents("bryant-stories.txt")
simplified_sentences_bryant  = [[word.lower() for word in sent if word not in punctuation] for sent in bryant_sents]
bryant_model = gensim.models.Word2Vec(simplified_sentences_bryant)

# Obtains the sentences in the bible-kjv.txt file and puts all words in lower case and attempts to remove punctuation
# Then the Word2Vec model is created for the bible text. 
bible_sents = gutenberg.sents("bible-kjv.txt")
simplified_sentences_bible = [[word.lower() for word in sent if word not in punctuation] for sent in bible_sents]
bible_model = gensim.models.Word2Vec(simplified_sentences_bible)


# ## Qualitative Analysis
# 
# Word2Vec, and other embeddings, are often evaluated in terms of how intuitively related cherry-picked words are to lists of nearby words are. For each of the 5 models, find the (up to) 10 words most similar to the following sentiment-related words:
# 
# - laugh, joy, love
# - sorrow, hate, anger
# 
# Not all words will be in all embeddings.  Be sure to handle any words that are not found.  Describe any trends you observe.  You will encounter some very strange matches, which is largely due to the small amount of data.

# In[11]:


# Creates the list of words that are desired to observe similarities to per the previous question.
sentiment_words= ['laugh', 'joy', 'love', 'sorrow', 'hate', 'anger']


# ### Blake-poems model

# In[12]:


# Cycles through the list of desired sentiment-related words and prints the most similar top ten words to each of the 
# sentiment words. If the word was not found in the embeddings, the error is handled and printed out that the word
# was not found. 
for i in range(len(sentiment_words)):
    print("\n10 most similar words to", sentiment_words[i], ":")
    try: 
        print(blake_model.wv.most_similar(sentiment_words[i]))
    except KeyError:
        print(sentiment_words[i], "was not found in embeddings")
        


# #### Just above, are the word similarities to each of the sentiment-related words for the Blake-poems model. The terms 'hate' and 'anger' were not found in the embeddings. However, the terms 'laugh', 'joy', 'love', and 'sorrow' were found. In each of these terms' word similarities, it seemed that there were a large amount of stop words on average in the top 10 similiar words (i.e.  'and', 'the', 'with', etc.). In general, it seemed that the stop words were the majority of the top ten most common similar word to all of the sentiment-related words. This may be a factor of the small data size or the high presence of stop words around these words in the text. However, for the terms that did not just have stop words included in the top 10 similar words, they were in fact relatable back to the word of interest and made sense to be associated with it. 
# 

#  

# ### Melville-Moby_Dick model 

# In[13]:


# Cycles through the list of desired sentiment-related words and prints the most similar top ten words to each of the 
# sentiment words. If the word was not found in the embeddings, the error is handled and printed out that the word
# was not found. 
for i in range(len(sentiment_words)):
    print("\n10 most similar words to", sentiment_words[i], ":")
    try: 
        print(moby_model.wv.most_similar(sentiment_words[i]))
    except KeyError:
        print(sentiment_words[i], "was not found in embeddings")
        


# #### Just above, are the word similarities to each of the sentiment-related words for the Moby_Dick model. The only term not found in these embeddings was 'anger'. Addtionally, it seemed that the majority of the top ten words were associated with words that were not stop words. There were was a similarity to punctuation not previously removed on average (over the course of multiple runs). It did seem that the words that were found in embeddings had words similar that made sense. For instance, in one iteration, the term 'laugh' had words like 'boy', 'hope', and 'mad', which are all possible words to be associated with laughing. However, for the terms 'joy' and 'hate', in that same iteration, there were some interesting words included that did not seem like they would normally be associated with them. For 'joy' the term 'cold' was included in one iteration,  which seemed kind of strange to think about off hand. For 'hate' the term 'kind' and 'fair' was included in the similar terms for one iteration also, which seems contradictory.  In another iteration for 'hate', the terms 'good', 'content', and 'best' were within the top ten similar words. These are words that are likely to be more associated with a term of happiness or peace with something rather than hatred. 

# ###  Milton-Paradise model

# In[14]:


# Cycles through the list of desired sentiment-related words and prints the most similar top ten words to each of the 
# sentiment words. If the word was not found in the embeddings, the error is handled and printed out that the word
# was not found. 
for i in range(len(sentiment_words)):
    print("\n10 most similar words to", sentiment_words[i], ":")
    try: 
        print(milton_model.wv.most_similar(sentiment_words[i]))
    except KeyError:
        print(sentiment_words[i], "was not found in embeddings")
        


# ####  Just above, are the word similarities to each of the sentiment-related words for the Paradise model. The only term that was not found in the embeddings was 'laugh'. Additionally, it seemed that the majority of the top ten most similar words with all the terms were stop words (on average) and that there were a few instances of similarities to unremoved punctuations on average. This may be a factor of the small data size or the high presence of stop words around these words in the text. For the similar words that were not stop words, it seemed that the terms could be associated with the similar words.  For example, the term 'anger' included the terms 'power' , 'new', and 'themselves' that were not stop words in one iteration of the model. The term 'power' could be associated with anger in a negative connotation, 'new' could be associated with the fact that anger was newly created by something, and 'themselves' could be associated with anger with respect to where anger is directed. 

# ### Bryant-Stories model

# In[15]:


# Cycles through the list of desired sentiment-related words and prints the most similar top ten words to each of the 
# sentiment words. If the word was not found in the embeddings, the error is handled and printed out that the word
# was not found. 
for i in range(len(sentiment_words)):
    print("\n10 most similar words to", sentiment_words[i], ":")
    try: 
        print(bryant_model.wv.most_similar(sentiment_words[i]))
    except KeyError:
        print(sentiment_words[i], "was not found in embeddings")


# ####  Just above, are the word similarities to each of the sentiment-related words for the Bryant  model. The terms 'hate' and 'anger' were not found in the word embeddings for this model. On average, there was at least one similar word that was a punctutation that was not previously removed. Additionally, it seemed that the words that did have word embeddings had terms in the top ten similar words that were not just stop words and that made sense with the sentiment term associated with it. For example, in one iteration of the model the term 'laugh' had the terms 'children', 'great', and 'father' in the top most similar words, which could all be associated with laughing. Another example,in the same iteration, was for the term 'sorrow', which had similar terms such as 'love', 'poor', 'cried', and 'never'. All of these similar terms could easily be associated with the term 'sorrow'. 

# ### Bible model 

# In[16]:


# Cycles through the list of desired sentiment-related words and prints the most similar top ten words to each of the 
# sentiment words. If the word was not found in the embeddings, the error is handled and printed out that the word
# was not found. 
for i in range(len(sentiment_words)):
    print("\n10 most similar words to", sentiment_words[i], ":")
    try: 
        print(bible_model.wv.most_similar(sentiment_words[i]))
    except KeyError:
        print(sentiment_words[i], "was not found in embeddings")
        


# ####  Just above, are the word similarities to each of the sentiment-related words for the Bible model. All sentiment terms had embeddings for this model. Also, the majority of the similar terms were not composed of stopwords and seemed to make sense with the sentiment term to which it belonged. For instance, in one iteration, the sentiment term 'anger' had similar words like 'enemies', 'power', and 'strength', which could have all been associated with the term 'anger' normally. Also, in the same iteration, the sentiment term 'love', had similar words like 'comfort', 'recieve', 'desire', and 'delight', which all are words that could also be normally assoicated with love.   

# #### Overall, of the models, it seemed that in the cases that the similar words were not completely composed of stop words, that the Word2Vec models were generally able to identify words that are similar to the target words. These results are based off of small datasets and may be apt to be improved by utilizing larger datasets and more text for training. 
