import { createSlice } from "@reduxjs/toolkit";
import { findAllArticles, findArticleById } from "./article.service";
import { Pending } from "@mui/icons-material";
import build from "next/dist/build";
import { initialState } from "./article.init";

const articleThunks = [findAllArticles,findArticleById]
const status = {
    pending:'pending',
    fullfilled : 'fullfilled',
    rejected: 'rejected'
}

const handleFulfilled =  (state: any, {payload}: any) => {
    state.array = payload
}



export const articleSlice = createSlice({
    name: "article",
    initialState,
    reducers: {},
    extraReducers: builder => {
        const {pending, rejected} = status;

        builder.addCase(findAllArticles.fulfilled, handleFulfilled)
        builder.addCase(findArticleById.fulfilled, (state: any, {payload}: any)=>{state.json = payload})
    }
})

export const getAllArticles  = (state: any) => {
    return state.article.array;
}
export const getfindArticleById  = (state: any) =>  state.article.json;

export const {} = articleSlice.actions
export default articleSlice.reducer;