defmodule LuckyTickets do
  def calculate_by_loop do
    Enum.count(for a <- 0..9, b <- 0..9, c <- 0..9, d <- 0..9, e <- 0..9, f <- 0..9, a + b + c === d + e + f, do: [])
  end
end