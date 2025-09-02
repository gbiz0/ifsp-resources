import { z } from "zod";

export const SalaCreateSchema = z.object({
  descricao: z
    .string({ required_error: "descricao é obrigatória" })
    .min(1)
    .trim(),
  localizacao: z
    .string({ required_error: "localizacao é obrigatória" })
    .min(1)
    .trim(),
  capacidade: z
    .number({ required_error: "capacidade é obrigatória" })
    .int()
    .nonnegative(),
});

export const SalaUpdateSchema = SalaCreateSchema; // mesmo shape

export function parseBody(schema, body) {
  const result = schema.safeParse(body);
  if (!result.success) {
    const issues = result.error.issues.map((i) => ({
      path: i.path.join("."),
      message: i.message,
    }));
    const err = new Error("VALIDATION_ERROR");
    err.status = 400;
    err.details = issues;
    throw err;
  }
  return result.data;
}
